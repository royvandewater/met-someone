(ns met-someone.setup
  (:gen-class)
  (:require [clojure.java.jdbc :as sql]))

(defn -main []
  (sql/with-connection
    {:classname "org.h2.Driver"
     :subprotocol "h2:file"
     :subname "db/met-someone"}

    (sql/create-table :meetings
      [:id "bigint primary key auto_increment"]
      [:created_at "datetime"]
      [:updated_at "datetime"])))
