(ns core
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [cljs-http.client :as http]
            ["xhr2" :as xhr2]
            [cljs.core.async :refer [<!]]))

(set! js/XMLHttpRequest xhr2)

(defn http-request
      []
  (go (let [response (<! (http/get "https://api.github.com/users"
                                   {:with-credentials? false
                                    :query-params {"since" 135}}))]
        (prn (:status response))
        (prn (map :login (:body response)))))
      )

(defn handler [_ _ cb]
      (http-request)
      (cb nil
          #js {:statusCode 200
               :body (js/JSON.stringify "Hello from Shadow")}))