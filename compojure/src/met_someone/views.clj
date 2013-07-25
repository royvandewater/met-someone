(ns met-someone.views
  (:require [met-someone.db :as db]
            [clojure.string :as str]
            [hiccup.page :as hic-p]
            [ring.util.response :as resp]))

(defn- generate-page-head [title]
  [:head 
    [:title title]
    (hic-p/include-css "/css/styles.css")])

(defn- header-links []
  [:div#header-links
   "[ "
   [:a {:href "/"} "Home"]
   " | "
   [:a {:href "/new"} "New Meeting"]
   " ]"])

(defn meeting-index []
  (let [meetings (db/get-all-meetings)]
    (hic-p/html5
      (generate-page-head "Meetings")
      (header-links)
      [:h1 "Meetings"]
      [:p  (str "Listing all (" (count meetings) ") meetings")]
      [:ul (for [meeting meetings]
        [:li (:created_at meeting)])])))

(defn meeting-new []
  (hic-p/html5
    (generate-page-head "New Meeting")
    (header-links)
    [:h1 "New Meeting"]
    [:form {:action "/", :method "POST"}
      [:p [:input {:type "Submit", :value "Met Someone"}]]]))

(defn meeting-create [params]
  (db/add-meeting-to-db)
  (resp/redirect "/"))
