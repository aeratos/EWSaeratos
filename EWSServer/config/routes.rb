Rails.application.routes.draw do

  get "/", :to => "welcome#index"
  get "/quake", :to => "quake#get"
  get "/status", :to => "status#index"

  get 'auth/:provider/callback', to: 'sessions#create'
  get 'auth/failure', to: redirect('/')
  get 'signout', to: 'sessions#destroy', as: 'signout'

  resources :sessions, only: [:create, :destroy]

  get "/login", :to => "login#show"
  root to: "login#show"

end
