(ns sicp-clojure.sec1-2
	(:use [sicp-clojure.sec1-1])
	(:gen-class))

(defn factorial [n]
	(if (= n 1)
		1
		(* n (factorial (- n 1)))))

(defn fact-iter [product counter max-count]
	(if (> counter max-count)
		product
		(fact-iter (*' counter product)		; *' allows for arbitrary precision - see http://intothewebs.tumblr.com/post/46435245410/more-clojure-tail-call-optimization-and-loop-recur
							(+ counter 1)
							 max-count)))

(defn factorial-iter [n]
	(fact-iter 1 1 n))

(defn factorial-tco [n]
	(loop [count n acc 1]
		(if (zero? count) acc
			(recur (dec count) (*' count acc)))))

(defn A [x y]
;Ackermann function
	(cond (= y 0) 0
				(= x 0) (* 2 y)
				(= y 1) 2
				:else (A (- x 1) (A x (- y 1)))))

(defn fib-iter [a b count]
	(if (= count 0)
			b
			(fib-iter (+ a b) a (- count 1))))

(defn fib [n]
	(fib-iter 1 0 n))

(defn first-denomination [kinds-of-coins]
	(cond (= kinds-of-coins 1) 1
				(= kinds-of-coins 2) 5
				(= kinds-of-coins 3) 10
				(= kinds-of-coins 4) 25
				(= kinds-of-coins 5) 50))

(defn cc [amount kinds-of-coins]
	(cond (= amount 0) 1
				(or (< amount 0) (= kinds-of-coins 0)) 0
				:else (+ (cc amount (- kinds-of-coins 1))
								 (cc (- amount (first-denomination kinds-of-coins)) kinds-of-coins))))
								 
(defn count-change [amount]
	(cc amount 5))

;Exercise 1.11
;f(n)=n if n<3, f(n)=f(n-1)+2f(n-2)+3f(n-3) if n>=3

;Recursive
(defn ex1-11 [n]
	(if (< n 3)
			n
			(+ 			(ex1-11(- n 1)) 
				 (* 2 (ex1-11(- n 2))) 
				 (* 3 (ex1-11(- n 3))))))

;Iterative
;Solution from http://community.schemewiki.org/?sicp-ex-1.11
(defn ex1-11-iter [n]
	(defn ex111help [a b c m]
		(if (< m 3)
			a
			(ex111help (b c (+ c (* 2 b) (* 3 a) (dec m))))))
	(ex111help 0 1 2 n))


;Exercise 1.12
;Pascal's triangle, left-aligned
(defn pascal [col row]
	(if (or (= 0 col) (= col row))
		1
		(+ (pascal (- col 1) (- row 1)) (pascal col (- row 1)))))

;testing Pascal's function
;(for [row (range 0 10) col (range 0 (inc row))] (pascal col row))

;1.2.4 Exponentiation
(defn expt [b n]
;Linear Recursive Process = O(n) steps + O(n) space
	(if (= n 0)
		1
		(*' b (expt b (dec n)))))

(defn expt-iter [b counter product]
;Linear iteration = O(n) steps and O(1) space
	(if (= counter 0)
	product
	(expt-iter b (dec counter) (*' b product))))

;O(log n) growth
(defn fast-expt [b n]
	(cond (= n 0) 1
				(even? n) (square (fast-expt b (/ n 2)))
				:else (* b (fast-expt b (dec n)))))

;Exercise 1.16
;implement fast-expt with an INVARIANT QUALITY

(defn fast-expr-iter [b n]
	(defn help [a b n]
		(cond (= n 0) a														;exit condition
			(even? n) (help a (square b) (/ n 2))
			(odd? n)	(help (* a b) b (dec n))))
	 (help 1 b n))															;iq starts at 1




			
