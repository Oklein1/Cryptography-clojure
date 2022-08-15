(ns cyptography.core
  (:gen-class)
  (:require [cyptography.caeserEncryption :refer :all]))




;;;;;;;;;;;;;;;;;;;;;;;;
;;;    INFORMATION  ;;;;
;;;;;;;;;;;;;;;;;;;;;;;;

;; ASCII ALPHABET:
;; Begins: a == 97
;; Ends: z == 122


;;;;;;;;;;;;;;;;;;;;;;;;
;;;       GOAL      ;;;;
;;;;;;;;;;;;;;;;;;;;;;;;

;; Impliment basic Caeser cipher


(def message "My name is Ofir and the message is encrypted")

(defn main []
  (do
    (println "Original Message:" message)
    (caeser-cipher-encryption 5 message)
    (def encrypted-message (caeser-cipher-encryption 5 message))
    (println "Message Encrypted:" encrypted-message)
    (println "Message Decrypted"(caeser-ciper-decrypted 5 encrypted-message))))






(main)