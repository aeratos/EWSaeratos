class StatusController < ApplicationController
    def index
	passw="ectrodattiliadisplasiaectodermica"                           #First part of password
        if current_user                                                 #If User is logged I can send to Client the first part of password
            userType=params[:type]
            current_user.typeU = userType
            current_user.save!
            name=current_user.name
            ret ={"status" => "logged", "type" => userType.to_s, "name" => name.to_s, "pass" => passw.to_s}
            render json: ret
        else
            ret ={"status" => "unlogged"}
            render json: ret
        end
    end
end
