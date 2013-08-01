(ns met-someone.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.page :only [include-css html5]]))

(defn- header-links []
  [:div#header-links
   "[ "
   [:a {:href "/"} "Home"]
   " | "
   [:a {:href "/new"} "New Meeting"]
   " ]"])

(defn- new-meeting-button []
  [:form.navbar-form {:action "/", :method "POST"}
    [:p 
      [:input.btn.btn-primary {:type "Submit", :value "Met Someone"}]]])

(defn- navbar []
  [:div.navbar.navbar-fixed-top
    [:div.container
      [:a.navbar-brand {:href "/"} "Met Someone"]
      [:ul.nav.navbar-nav
        [:li 
          (new-meeting-button)]]]])

(defpartial layout [& content]
            (html5
              [:head
                [:title "met-someone"]
                (include-css "/css/bootstrap.css"
                             "/css/style.css")]
              [:body
                [:div.container 
                  [:div.meeting-template
                    (navbar)
                    content]]]))
