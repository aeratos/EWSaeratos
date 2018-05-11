Rails.application.routes.draw do

    get "/", :to => "welcome#index";
    get "/quake", :to => "quake#get";

end
