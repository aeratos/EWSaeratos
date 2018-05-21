# EWSaeratos

**EWSaeratos** is a project developed to increase civil protection. **Aeratos** team believes that in a emercency situation every seconds could make the difference, for this reason we built a desktop application to launch civil warnings in case of earthquake.
Premium users can also get a list of last earthquakes, filtering them by location, distance and magnitude.

## SERVER

To open the server, type: 

```
$ bundle install  
$ rake db:migrate  
$ rails start
```
Open your browser and go to "http://localhost:3000/ and follow the instruction to download the Client

![GitHub Logo](homePage.png)



### Privacy 
Privacy is garanteed by the integration of *Google Oauth* protocol.
When Rails server starts, it use the following function to create a logger:

```Ruby
OmniAuth.config.logger = Rails.logger

#Google client id = 543824881127-hilli6393c0dvcb66en2s1695l1i9t8p.apps.googleusercontent.com
#Google client secret = DmBRdM2XryjfoGqZpa48ytCa

#Oauth middleware
Rails.application.config.middleware.use OmniAuth::Builder do
  provider :google_oauth2, '543824881127-hilli6393c0dvcb66en2s1695l1i9t8p.apps.googleusercontent.com', 'DmBRdM2XryjfoGqZpa48ytCa',      access_type: 'online', prompt: ''
end
```
The logger allows you to storage the current user in a SQLITE database with this form:

```Ruby
class User < ActiveRecord::Base
  def self.from_omniauth(auth)
    where(provider: auth.provider, uid: auth.uid).first_or_initialize.tap do |user|
      user.provider = auth.provider
      user.uid = auth.uid
      user.name = auth.info.name
      user.typeU = '0'                                                  #this is type camp: 1=stardard 2=premium User
      user.oauth_token = auth.credentials.token
      user.oauth_expires_at = Time.at(auth.credentials.expires_at)
      user.save!
    end
  end
end
```

### Earthquake Info ###
The Earthquake infos are provided by a Government agency, the United States Geological Survey (USGS), using the API https://earthquake.usgs.gov/fdsnws/event/1/

```Ruby
class QuakeController < ApplicationController

    require 'open-uri'
    require 'json'

    def get

        limitValue=params[:limit]
        password = params[:passw]

        if password == "ectrodattiliadisplasiaectodermicalabiopalatoschisi"     #complete password

            url="https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&eventtype=earthquake&orderby=time&limit=" + limitValue.to_s    #USGS api
            prova= open(url, &:read)

            data = JSON.parse(prova)
            features = data["features"]

            retArr = Array.new(limitValue.to_i-1)

            for i in 1..limitValue.to_i
                earthquake =features[i-1]
                properties = earthquake["properties"]
                geometry = earthquake["geometry"]
                coordinates = geometry["coordinates"]

                id = earthquake["id"];
                magnetude= properties["mag"]
                place= properties["place"]
                time=properties["time"].to_i

                timeEpo = Time.at(time /1000).to_s

                formattedTime=timeEpo.split(" ")[0] +" "+ timeEpo.split(" ")[1] ;

                ret ={"id"=> id.to_s, "magn" => magnetude.to_s, "place" => place.to_s, "time" => formattedTime.to_s, "coord" => coordinates }
                retArr[i-1]=ret
            end

            render json: {"elem" => retArr}

        else
            render json: {"status" => "error"}
        end
    end

end
```
### Security ###
The communication are secured by using a two-step password. The first half of the password is sent to client by the server after the loggin, while the second part is stored in the client. By merging the two part, the client obtains the final password, it will be used to guarantee the access to earthquakes informations.
With this approach we can guarantee that a user must use the client application and must be logged to gain earthquake informations.

Rails function used to send password to client:

```Ruby
class StatusController < ApplicationController
    def index
	passw="ectrodattiliadisplasiaectodermica"                           #First part of password
        if current_user                                                 #If User is logged I can send to Client the first part of password
            userType=params[:type]
            current_user.typeU = userType
            current_user.save!
            ret ={"status" => "logged", "type" => userType.to_s, "pass" => passw.to_s}
            render json: ret
        else
            ret ={"status" => "unlogged"}
            render json: ret
        end
    end
end
```
