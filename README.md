# EWSaeratos

**EWSaeratos** is an application aimed at guaranteeing the safety of people in the event of an earthquake.
It also provides useful informations about the latest records of global and local earthquakes.

## SERVER

To open the server, type: 

```
$ bundle install  
$ rake db:migrate  
$ rails start
```
Open your browser and go to "http://localhost:3000/ and follow the instruction to download the Client

![GitHub Logo](homePage.png)



### Privacy ###
Your Privacy is garanteed by the integration of *Google Oauth* protocol.
On startup of Rails server is created a logger with this function:

```Ruby
OmniAuth.config.logger = Rails.logger

#Google client id = 543824881127-hilli6393c0dvcb66en2s1695l1i9t8p.apps.googleusercontent.com
#Google client secret = DmBRdM2XryjfoGqZpa48ytCa

#Oauth middleware
Rails.application.config.middleware.use OmniAuth::Builder do
  provider :google_oauth2, '543824881127-hilli6393c0dvcb66en2s1695l1i9t8p.apps.googleusercontent.com', 'DmBRdM2XryjfoGqZpa48ytCa',      access_type: 'online', prompt: ''
end
```
This logger allows you to save the Current-User in a database (sqlite) with this form:

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

### Quake Fuctions ###
The report of latest earthquake is showed 
