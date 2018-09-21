(ns clojure-collections.patterns.entity)

;; Entity

(def eric
  {:name "Eric Normand"
   :address "124 Main St."
   :height 1.6
   :date-of-birth #inst "1981-07-18"})

(:name eric)
;; => "Eric Normand"

(:height eric)
;; => 1.6

(get eric :name)
;; => "Eric Normand"

(assoc eric :name "John Doe");; => {:name "John Doe", :address "124 Main St.", :height 1.6, :date-of-birth #inst "1981-07-18T00:00:00.000-00:00"}

(assoc eric :user-id "3221312")
;; => {:name "Eric Normand", :address "124 Main St.", :height 1.6, :date-of-birth #inst "1981-07-18T00:00:00.000-00:00", :user-id "3221312"}

(dissoc eric :name)
;; => {:address "124 Main St.", :height 1.6, :date-of-birth #inst "1981-07-18T00:00:00.000-00:00"}

;; Variant Entity

;; cash
;;   amount in dollars
;; check
;;   amount in dollars
;;   account #
;;   routing #
;; credit card
;;   number
;;   amount
;;   code
;;   expiration

{:payment-method :cash
 :amount 100}

{:payment-method :check
 :amount 100
 :account "43242342"
 :routing "4534534532"}

{:payment-method :credit
 :amount 100
 :number "43424255"
 :code "433"
 :exipration "11/23"}


{:shape :circle
 :radius 10}


{:account-type :admin
 :userid "42354536"
 :username "eric"
 :email "eric@lispcast.com"}


(defn save-payment-method-to-db! [entity]
  (case (:payment-method entity)
    :cash
    ;;
    :check
    ;;
    :credit
    ;;

    )
  )

(defn save-account-to-db! [entity]
  ;; 
  )




