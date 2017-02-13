(ns learncompojure.core
  (:require [compojure.core :refer :all]
            [org.httpkit.server :refer [run-server]]))


(defroutes myapp
  (GET "/" [] "Show something")
  (POST "/" [] "Create something")
  (PUT "/" [] "Replace something")
  (PATCH "/" [] "Modify something")
  (DELETE "/" [] "Annihilate something")
  (OPTIONS "/" [] "Appease something")
  (HEAD "/" [] "Preview something"))


(myapp {:uri "/" :request-method :get})
(myapp {:uri "/" :request-method :post})
(myapp {:uri "/" :request-method :put})
(myapp {:uri "/" :request-method :patch})
(myapp {:uri "/" :request-method :delete})
(myapp {:uri "/" :request-method :options})
(myapp {:uri "/" :request-method :head})


(defroutes myapp1
  (GET "/hello/:name" [name] (str "Hello " name)))

(myapp1 {:uri "/hello/Thinh" :request-method :get})


(defroutes myapp2
  (GET ["/file/:name.:ext" :name #".*", :ext #".*"] [name ext]
       (str "File: " name ext)))

(myapp2 {:uri "/file/thinh.trinh" :request-method :get})


(defn -main 
  "Run server"
  []
  (run-server myapp1 {:port 5000}))


