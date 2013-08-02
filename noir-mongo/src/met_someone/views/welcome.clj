(ns met-someone.views.welcome
  (:require [met-someone.views.common :as common])
  (:use [noir.core :only [defpage]]))

(defpage "/welcome" []
         (common/layout
           [:p "Welcome to met-someone"]))
