(defproject met-someone "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.5"]
                 [hiccup "1.0.2"]
                 [org.clojure/java.jdbc "0.2.3"]
                 [com.h2database/h2 "1.3.170"]]
  :plugins [[lein-ring "0.8.5"]]
  :ring {:handler met-someone.handler/app}
  :profiles
  {:dev {:dependencies [[ring-mock "0.1.5"]]}})
