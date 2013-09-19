;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname robot) (read-case-sensitive #t) (teachpacks ((lib "image.rkt" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "image.rkt" "teachpack" "2htdp")))))
(require 2htdp/image)
(require 2htdp/universe)

;(require
;  rackunit
;  rackunit/text-ui
;  "extras.rkt")

;(provide
;  initial-robot
;  robot-left 
;  robot-right
;  robot-forward
;  robot-north? 
;  robot-south? 
;  robot-east? 
;  robot-west?)

(define robot (circle 15 "solid" "blue"))
(define (robot-posn x y)
(cond
  [(< x 200) (place-image robot x y (empty-scene 200 200))]
  [(< y 200) (place-image robot x y (empty-scene 200 200))]
  [else  "Robot colliding the wall"]))
;  [(>= y 200)  ("Robot colliding the wall")]))
 ;(define (robot-posn x y))
  
  
  (robot-posn 100 100)