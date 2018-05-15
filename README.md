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
### Privacy ###
Your Privacy is garanteed by the integration of Google Oauth protocol.
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
