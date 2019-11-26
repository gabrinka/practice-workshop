#lang racket
;sum term
(define (sum-term term a b r)
  (if (> a b) r (sum-term term (+ 1 a) b (+ r (term a)) )
  ))

;accumulate na nasko, step e operaciqta nad argumentite + primerno
(define (accumulateN from to step term acc)
  (if (> from to)
    acc
    (accumulateN (+ from 1)
                 to
                 step
                 term
                 (step acc (term from)))))

;count-p,broq na chislata izppulnqvashti daden predikat
(define (count-p a b p)
  (define (inc-if acc x)
(if (p x) (+ 1 acc) acc)
    )
(accumulateN a b inc-if id 0)
  )
;for-all,dali daden predikat e veren za vsichki chisla ot intervala
(define (for-all? from to p)
  (define (and2 a b)
    (and a b))
  (accumulateN from to and2 p #t))
;exists dali nqkoe chislo v daden interval izpulnqva predikat
(define (exists? from to p)
(define (or2 a b)
  (or a b))
  (accumulateN from to or2 p #f))

;complement,za daden predikat vrushta otricanieto mu
(define (complement p)
  (lambda (x)(not (p x))))
;flip, za dadena funkciq vrushta funkciata amanad razmeneni argumenti
(define (flip f)
  (lambda (x y)( f y x)))
;double kompoziciq f ot f ot x
(define (double f)
  (lambda (x) (f (f x))))
;compose
(define (compose f g)
        (lambda (x) (f (g x))))
;repeat funkciqw
(define (repeat f n)
  (lambda (x)(if (= n 0) x ( f(repeat f (- n 1) x))) ))

;accumulate,nv stands for null value,rekursiven proces
(define (id x) x)
(define (next x) (+ x 1))
(define (accumulate op nv a b term next)
(if (> a b) nv (op (term a) (accumulate op nv (next a) b term next)))

  )
;left accumulate,iterativen proces,natrupvame rezultata v nv
(define (accumulate-i op nv a b term nex)
  (if (> a b ) nv (accumulate-i op (op nv (term a)) (next a) b term next)))


;funkciq koqto prilaga dadena funkciq dva puti nad argument
(define (twice f x) (f (f x)))
(define (twice2 f)(lambda (x) (f (f x))))
(define (n+ n)(lambda (i) (+ i n)))
(define 1+ (n+ 1))
(define (compose2 f g)(lambda (x)(f (g x)))
  )
(define (repeated f n)
  (lambda (x)(if (= n 0) x (f ((repeated f (- n 1)) x)))))

(define (repeated2 f n x)
(if (= n 0) x (f (repeated2 f (- n 1) x)))
  )

;test na car i cdr
(car (cons (+ 2 3)(+ 1 3)))
(cdr (cons (* 9 0) (- 4 2)))

;izobraqvane na spisuk map
(define (map2 f l)
(if (null? l) '()
    (cons (f (car l)) (map2 f (cdr l)))))

;filtrirane na spisuk,vrushta samo elementite,koito izpulnqvat
;daden predikat 
(define (filter? p l)
(cond [(null? l) l]
      [(p (car l)) (cons (car l) (filter? p (cdr l)))]
      [else (filter? p (cdr l))])
  )
 ;dqsno svivane,natrupvane otdqsno
(define (foldrM op nv l)
  (if(null? l) nv

  (op (car l) (foldrM op nv (cdr l)))))

;lqvo svivane,natrupvane otlqvo,lineen iterativen proces
(define (foldlM op nv l)
  (if(null? l ) nv (foldlM op (op nv (car l)) (cdr l))))

;max element na spisuk
(define (maximum l ) (foldrM max (car l) l))

;definiciq na atom=element koito ne e dvoika i ne e nula
(define (atom? x) (and (not(null? x)) (not(pair? x))))

;broi na atomite v dulbok spisuk pr. '((1 (2)) (((3) 4) (5 (6)) () (7)) 8))
(define (count_atoms l)
(cond [(null? l) 0]
      [(atom? l) 1]
[else (+(count_atoms (car l)) (count_atoms (cdr l)))]
      )
  )
;subirane na atomi ot dulbok spisuk v nov
(define (flatten l)
(cond ((null? l) '())
((atom? l) (list l))
(else (append (flatten (car l)) (flatten (cdr l))))))

;reverse na dulboki spisuci
(define (deep-reverse l)
(cond ((null? l) '())
((atom? l) l)
(else (append (deep-reverse (cdr l))
(list (deep-reverse (car l)))))))


(define (fact n)
  (accumulate * 1 1 n id next))
;malko lambda upr
((lambda (a b) (+ a b)) 10 20)
((lambda (a)(* a 10)) 5)

(define t (lambda (x y) x))
(define f (lambda (x y) y))
(define (lambda-if b x y) ((b x y)))


;malko dvoiki testove ala bala
(cons (+ 2 3)(* 6 10))


;list exercises
(define (length* lst)
  (if (null? lst)
    0
    (+ 1
       (length* (cdr lst)))))
;suma 
(define (sum lst)
  (if (null? lst)
    0
    (+ (car lst)
       (sum (cdr lst)))))


;ntiq element na spisuk
(define (nth n lst)
  (define (helper pos lst)
(cond [(null? lst) 'nope]
      [(= n pos) (car lst)]
      [(helper (+ pos 1) (cdr lst))])

    )(helper 0 lst))
  





;posleden element????
(define (last* lst)
  (if (null? (cdr lst))
    (car lst)
    (last(cdr lst))))

(define (concat2 list1 list2)
  (if (null? list1)
    list2
    (cons ( car list1) (concat2 (cdr list1) list2))))
;konkatenaciq mai
(define (concat list1 list2)
  (if (null? list1)
    list2
    (cons
      (car list1)
      (concat (cdr list1) list2))))


(define (square x) (* x x))
; 6. mapche 
(define (map* f lst)
  (if (null? lst)
    lst
    (cons
      (f (car lst))
      (map* f (cdr lst)))))

; 7. filterche
(define (filter* p lst)
  (cond [(null? lst) lst]
        [(p (car lst)) (cons(car lst)(filter* p (cdr lst)))]
        [else (filter* p (cdr lst))]))
;vtori opit na filterche
;to do:8ma


;reverse-9ta
(define (reverse* lst)
  (define (helper acc lst)
    (if (null? lst)
      acc
      (helper (cons (car lst) acc)
            (cdr lst))))
  (helper '() lst))

;10ta foldr
(define (foldr* op acc lst)
  (if (null? lst) acc
      (op (car lst)
          (foldr* op acc (cdr lst)))))

;11ta foldl
(define (foldl* op acc lst)
  (if (null? lst)
    acc
    (foldl* op
            (op acc (car lst))
            (cdr lst))))


;12ta duljina na list izpolzaiki foldl
(define (length** lst)
  (foldl* (lambda (x i) (+ x 1)) 0 lst))

; 13. count-atoms
(define (count-atoms lst)
  (cond [(null? lst) 0]
        [(not (pair? lst)) 1]
        [else (+ (count-atoms (car lst))
                 (count-atoms (cdr lst)))]))

;vreushta samo purvite n elementa
(define (take xs n)
  (define (help i xs)
(if (> i n) '()
    (cons (car xs) (help (+ i 1) (cdr xs)))
    ))
  (help 1 xs)
  )
;vrushta spisuka bez purvite n elemnta
(define (drop xs n)
  (define (help i xs)
    (cond [(< i n) (help (+ i 1) (cdr xs))]
        [(null? xs) '()]
         [(= i n) xs ]

         )) (help 0 xs))

  

;transpose a matrix
(define (transpose m)
  (apply map list m))
;prefix,vrushta true ako xs e podspisuk na ys i xs e nachaloto na ys
(define (prefix? xs ys)
  (if( equal? xs (take ys (length xs))) #t #f)
  )
  ;suffix same kato prefix ama v kraq na ys
(define (suffix? xs ys)
  (if( equal? xs (drop ys (- (length ys)(length xs)))) #t #f)
  )
;namira chislata po-golemi ot srednoto arithmetichno v daden spisuk
(define (find-average xs)(/ (foldr + 0 xs) (length xs) ))
(define (better-than-average xs)
  (define (helper i xs)
  (cond [(null? xs) '()]
        [(>(car xs) i) (cons (car xs) (helper i (cdr xs)))]
        [ else (helper i (cdr xs))])
  )(helper (find-average xs) xs))

;middle digits ,namira srednite 2 cifri ot dadeno estestveno chislo n
(define (num_of_digits n)
  (cond [(< n 10) 1]
         [(+ 1 (num_of_digits (quotient n 10)))]
))
(define (middle-digits n)
(define (helper i)
  (cond [(= i (/(num_of_digits n) 2)) (cons (remainder (quotient n (expt 10 i)) 10) (helper (+ i 1)))]
        [(= i (+ (/(num_of_digits n) 2) 1)) (cons (remainder(quotient n (expt 10 (- i 2))) 10) (helper (+ i 1)))]
        [(> i n) '()]
        [(odd? n) '()]
        [else (helper (+ i 1))]
        ))(helper 1)
  )


;check matrix posle moga da q foldna s and
(define (check-list? m k) ;za spisuk samo 
    (foldl (lambda (x acc)(and acc (zero?(remainder x k)))) #t m )) 

(define (check-matrix? m k)
(foldl (lambda (row acc)(and acc (check-list? row k))) #t m
  ))

;funkciq koqto namira maks chislo ot unikalnite ot spisuk ot spisuci
;pomoshtna za namirane na unikalno chislo v list
; (define (foldl* op acc lst)
  ;(if (null? lst)
   ; acc
    ;(foldl* op
     ;       (op acc (car lst))
      ;      (cdr lst))))

(define (unique? x xs)
(= (foldl (lambda (y acc)
            (if(= x y)(+ acc 1) acc)) 0 xs) 1)
  )
(define (flat-unique xss)
(apply append (map (lambda(l) (filter (lambda (x)(unique? x l)) l)) xss))
  )
; lambda l shtot unique iskam da go vikam za edin element ot spisuk a inache sh stane da go vikam
;za purviq spisuk ot spisuka 

(define (max-unique xss)
  (if (null? (flat-unique xss))
    #f
    (apply max (flat-unique xss))))
;endomorfizum
; dali za vsqko chislo ot spisuk daden predikat e izpulnen
(define (every? p l)
  (or (null? l)
      (and (p (car l)) (every? p (cdr l)))))

(define (endomorphism? l op f)
(define (image-in-l? x)
  (member (f x) l))
  (define (f-preserves-op? x y)
    (=(op (f x) (f y)) (f (op x y))))
(and (every? image-in-l? l)
     (every? (lambda (x)(every? (lambda (y) (f-preserves-op? x y)) l)) l)

  ))

;polinom
(define (calcPoly l x)
  (if (null? l) 0 (foldl (lambda (a acc)(+(* acc x) a)) 0 l)))
;intersection of two sets
(define (intersection L M)
  (filter (lambda (x)
            (member x M))
          L))

(define (unique L)
  (if (null? L)
      L
      (let ((h (car L)))
        (cons h (unique (filter (lambda (x)
                                  (not (equal? x h)))
                                L))))))

(define (union L M)
  (unique (append L M)))



(define (bigger_num x y)(if (> x y) x y))

(define (sum-common-divisors x y)
  (define (helper from to acc)
(cond [(and (= (remainder x from) 0) (= (remainder y from) 0))
       (helper (+ from 1) to (+ acc from))]
      [(> from to) acc]
      [else (helper (+ from 1) to acc)]
    )) (helper 1 (bigger_num x y)  0))

;(define (greatest-sum a b)
 ; (define helper_f f from to lst)
  ;(if (> from to) '() (cons (helper_f) )))

;checks whether the metric preserves the value of a list
(define (findm? p l)
(if (null? l) 0 (p l))
  )
;checks whether the metric preserves the value of a list of a list
(define (everym? p l)
  (or (null? l)
       (=(findm? p (car l)) (findm? (every? p (cdr l))))))
(define (count-metrics m1 l1)
(define (helper-i acc m l)
  (cond [(everym? (car m) l) (helper-i (+ 1 acc) (cdr m) l)]
      [(helper-i acc (cdr m) l)]
      [(null? m) acc]
      
  )) (helper-i 0 m1 l1))

(define (atom? x) (and (not(null? x)) (not(pair? x))))
(define (level-flatten l)
(cond ((null? l) '())
((atom? l) (list l))
(else (append (level-flatten (car l)) (level-flatten (cdr l))))))






























