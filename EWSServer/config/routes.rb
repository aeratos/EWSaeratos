Rails.application.routes.draw do

  get "/", :to => "welcome#index"                                       #Homepage
  get "/quake", :to => "quake#get"                                      #Get quake page "/quake?limit=< >&passw=< >"
  get "/status", :to => "status#index"                                  #Set User type and get first part of password

  get 'auth/:provider/callback', to: 'sessions#create'
  get 'auth/failure', to: redirect('/')
  get 'signout', to: 'sessions#destroy', as: 'signout'

  resources :sessions, only: [:create, :destroy]

  get "/login", :to => "login#show"                                     #Oauth Login page
  root to: "login#show"

end
