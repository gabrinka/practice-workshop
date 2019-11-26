#lang racket
(define (bigger_num x y)(if (> x y) x y))

(define (sum-common-divisors x y)
  (define (helper from to acc)
(cond [(and (= (remainder x from) 0) (= (remainder y from) 0))
       (helper (+ from 1) to (+ acc from))]
      [(> from to) acc]
      [else (helper (+ from 1) to acc)]
    )) (helper 1 (bigger_num x y)  0))

(define (greatest-sumBETA a b)
 (define (helper_f from to next)
  (if (> next to) '()
   (cons (sum-common-divisors from next ) (helper_f from to (+ next 1))))
 ) (helper_f a b (+ a 1)))

(define (greatest-sum-list a b)
  (define (helpMe from to)
    (if (> from to) '()
        (append (greatest-sumBETA from to)(helpMe (+ 1 from) to))))
(helpMe a b))

(define (greatest-sum a b)
  ( apply max (greatest-sum-list a b)))

;create a list of the metric
(define (prod l)(apply * l))

(define (create-list m l)
(define (helper-f m1 l1)
  (cond [(null? l1) '()]
        [(cons (m1 (car l1)) (helper-f m1 (cdr l1)))]
        )) (helper-f m l)
  )

(define (check_if_m m l)
(define (helper l)
(apply = l)
  ) (helper (create-list m l)))


(define (count-metrics m l1)
  (define (counter acc m)
 (cond [(null? m) acc]
      [(check_if_m (car m) l1)(counter (+ 1 acc) (cdr m))]
      [(counter acc (cdr m))]
      [else acc]
)) (counter 0 m))


(define (atom? x) (and (not(null? x)) (not(pair? x))))
(define (level-flatten l counter)
(cond ((null? l) '())
((atom? l) (list (+ l counter)))
(else (append (level-flatten (car l) (+ counter 1)) (level-flatten (cdr l) counter)))))