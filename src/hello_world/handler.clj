(ns hello-world.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/toto" [] "hey je m'appelle toto")
  (route/resources "/")
  (route/not-found "Not Found"))

(defroutes second-route
  (GET "/parametre/:id" [id] (str "<h1>Hello user " id "</h1>"))
  (GET "/toto" [] "hey je m'appelle toto"))

(defroutes main-routes
  (context "/second" [] second-route)
  app-routes)


(def app
  (handler/site main-routes))
