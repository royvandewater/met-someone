(ns met-someone.db
  (:require [clojure.java.jdbc :as sql]))

(def db-spec {:classname "org.h2.Driver"
              :subprotocol "h2:file"
              :subname "db/met-someone"})

(defn current_time [] (new java.util.Date))

(defn add-meeting-to-db []
  (let [results (sql/with-connection db-spec
    (sql/insert-record :meetings {:created_at (current_time)}))]
    (assert (= 1 (count results)))
    (first (vals results))))

(defn get-all-meetings []
  (sql/with-connection db-spec
    (sql/with-query-results res 
      ["SELECT id, created_at FROM meetings"]
      (doall res))))
