(ns met-someone.models.meeting
  (:require [somnium.congomongo :as mongo]))

(def connection
  (mongo/make-connection "met-someone", :host "127.0.0.1", :port 27017))

(defn current_time [] (new java.util.Date))

(defn create []
  (mongo/with-mongo connection
    (mongo/insert! :meetings {:created_at (current_time)})))

(defn all []
  (mongo/with-mongo connection
    (mongo/fetch :meetings)))
