(ns met-someone.views.meeting
  (:require [met-someone.views.common :as common]
            [met-someone.models.meeting :as meeting]
            [noir.response :as response])
  (:use [noir.core :only [defpage]]))

(defpage "/" []
  (let [meetings (meeting/all)]
    (common/layout
      [:h1 "Meetings"]
      [:p  (str "Listing all (" (count meetings) ") meetings")]
      [:ul (for [meeting meetings]
        [:li (:created_at meeting)])])))

(defpage [:post "/"] []
  (meeting/create)
  (response/redirect "/"))
