(ns hello-world.test.handler
  (:use clojure.test
        ring.mock.request  
        hello-world.handler))

(deftest test-app
  (testing "main route"
    (let [response (app (request :get "/"))]
      (is (= (:status response) 200))
      (is (= (:body response) "Hello World"))))
  
  (testing "not-found route"
    (let [response (app (request :get "/invalid"))]
      (is (= (:status response) 404))))

    (testing "second route"
    (let [response (app (request :get "/second/parametre/charles"))]
      (is (= (:status response) 200))
      (is (= (:body  response) "<h1>Hello user charles</h1>"))))

        (testing "second route with toto"
    (let [response (app (request :get "/second/toto"))]
      (is (= (:status response) 200))
      (is (= (:body  response) "hey je m'appelle toto"))))

  )
