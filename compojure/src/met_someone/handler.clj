(ns met-someone.handler
  (:use compojure.core)
  (:require [met-someone.views.meeting :as meeting]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [clojure.java.jdbc :as sql]))

(defroutes app-routes
  (GET  "/"    []               (meeting/index))
  (GET  "/new" []               (meeting/new))
  (POST "/"    {params :params} (meeting/create params))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
