(ns met-someone.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.page :only [include-css html5]]))

(defpartial layout [& content]
            (html5
              [:head
                [:title "met-someone"]
                (include-css "/css/bootstrap.css"
                             "/css/style.css")]
              [:body
                [:div.container 
                  [:div.meeting-template
                    content]]]))
