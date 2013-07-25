(ns met-someone.handler
  (:use compojure.core)
  (:require [met-someone.views :as views]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [clojure.java.jdbc :as sql]))

(defroutes app-routes
  (GET  "/"    []               (views/meeting-index))
  (GET  "/new" []               (views/meeting-new))
  (POST "/"    {params :params} (views/meeting-create params))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
