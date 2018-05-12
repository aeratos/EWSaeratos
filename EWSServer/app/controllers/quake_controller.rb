class QuakeController < ApplicationController

    require 'open-uri'
    require 'json'

    def get

        limitValue=params[:limit]

        url="https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&eventtype=earthquake&orderby=time&limit=" + limitValue.to_s
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
          time=properties["time"]

          ret ={"id"=> id.to_s, "magn" => magnetude.to_s, "place" => place.to_s, "time" => time.to_s, "coord" => coordinates }
          retArr[i-1]=ret
        end

        render json: {"elem" => retArr}
    end

end
