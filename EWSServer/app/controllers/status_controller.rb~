class StatusController < ApplicationController
    def index
        if current_user
            userType=params[:type]
            current_user.typeU = userType
            current_user.save!
            ret ={"status" => "logged", "type" => userType.to_s}
            render json: ret
        else
            ret ={"status" => "unlogged"}
            render json: ret
        end
    end
end
