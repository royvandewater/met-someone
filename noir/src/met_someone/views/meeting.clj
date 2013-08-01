(ns met-someone.views.meeting
  (:require [met-someone.views.common :as common]
            [noir.content.getting-started])
  (:use [noir.core :only [defpage]]))

(defpage "/" []
  (common/layout
    [:h1 "Meetings"]))
