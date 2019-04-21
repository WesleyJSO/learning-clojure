(ns clojure-noob.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
  (println "Cleanliness is next to godliness")

;; ======================== basic conditional ========================
;; basic if then else example
;; used for one line return
(if false
  "By Zeus's hammer!"
  "By Aquaman's trident!")

;; basic multi line if then else example
;; here the 'do' key is used execute multiple lines of code
(defn a 
  (if true
    (do (println "Success!")
      "By Zeus's hammer!")
    (do (println "Failure!")  
      "By Aquaman's trident!")))
      
;; basic when example
;; used when only true condition is needed
(when true
  (println "Success!")
  "abra cadabra")

;; ======================== equality and truthness ========================
(nil? 1)

(nil? nil)

(= 1 1)

(= nil nil)

(= 1 2)

(if "if a string exists"
  "... then it is truthy")

;; returns 'nil is false'
(if nil
  "nil is true"
  "nil is false")

;; return the first true value, which is 'large_I_mean_venti'
(or false nil :large_I_mean_venti :why_cant_I_just_say_large)

;; returns the last value, which is 'false'
(or (= 0 1) (= "yes" "no"))

;; or nil returns 'nil'
(or nil)

;; returns the last truthy value, which is 'hot_coffee'
(and :free_wifi :hot_coffee)

;; returns 'hot_coffee'
(and :free_wifi true :hot_coffee)

;; returns false
(and :free_wifi true :hot_coffee)

;; returns nil
(and :free_wifi nil :hot_coffee)

;; returns nil, the first falsy statement (nothing nil here ;) )
(and :feelin_super_cool nil false)

;; this returns nil, which can be confusing, but makes all the sense
(get #{:a nil} nil)

;; this function returns true, it only validate the existence of the given value
(contains? #{:a nil} nil)

;; ======================== using def (variables... is that you???) ========================
(def failed-protagonist-names
  ["Larry Potter" "Doreen the Explorer" "The Incredible Bulk"])

;; defn is a function, it is called as (error-message), this function
;; receive only one parameter 'severity' which is
;; passed in the function call as (error-message [:variable-value])
(defn error-message
  [severity]
  (str "ho god! it's a disaster! we're "
    (if (= severity :mild)
      "mildly inconvinienced!"
      "doooomed!")))

;; ======================== map list set and vector structures ========================

;; creating a simple map
(def map-test
  {:first-name "Wesley" :last-name "Silva"})

;; use the hash-map function to bind a new map value to hash-map-test
(def hash-map-test
  (hash-map :first-name "Jose" :second-name "Wesley" :third-name "Silva" :last-name "Oliveira"))

;; to get a value from a map use the following structure
;; first, call the 'get' function, then put the map which the value will be extracted
(get hash-map-test :first-name)

;; 'get' function can return a default value if none as found for the given key
(get hash-map-test :my-name "Jose Wesley Silva de Oliveira")

;; 'get-in' function is used to get nested maps
(get-in {:first-name "Jose" :last-name "Silva" :children {:first-name "you won't have any"}} [:children :first-name])

;; also, you can treat maps like functions,
;; this allow you to avoid the 'get' function and just pass the key to return the value
({:my-name "Jose Wesley Silva de Oliveira"} :my-name)

;; you also can start with the key
(:my-name {:my-name "Jose Wesley Silva de Oliveira"})

;; vector can be created with '[]' (braces, I think that is the name) vector work the same way as maps
(def my-vector-of-info
  ["Jose Oliveira" 1991 "Male" {:age 28} "josewso55@gmail.com"])

;; and to get the data...
(my-vector-of-info 0)

;; there is a function to create vector, it's called 'vector' by the way (I like how things are simple here :] )
(vector "Jose Oliveira" 1991 "Male" {:age 28} "josewso55@gmail.com")

;; lists are weird :O
;; this create a list, the number 4 is added to beginning of the list
(def a-vector 
  (conj '(1 "two" 3 ) 4))

;; sets are collections of unique values
;; 'set' function tranforms a list into a hash set
(def hash-set-test
  (set [3 3 3 4 4]))

;; 'hash-set' creates a set
(def hash-set-test
  (hash-set 1 1 2 2))

;; function that receive a value and return true or false depending of the existence of the value in the hash
(defn contains-a-value
  [value]
  (contains? hash-set-test value))

;; ======================== functions ========================
;; functions can be nested
;; this returns a increment of 1 in each element of the vector,
;; then the map function take place and create a hash map of the incremented vector 
(map inc [0 1 2])

;; in clojure the functions have high priority
(+ (inc 199) (/ 100 (- 7 2))) ; first evaluate (inc 199)
(+ 200 (/ 100 (- 7 2)))       ; then all the inner parentesis, here the first one is (- 7 2)
(+ 200 (/ 100 5))             ; now it will evaluates the other inner parentesis, which is (/ 100 - 5)
(+ 200 20)                    ; finally the last parentesis is evaluated (+ 200 20)

;; function definition are composed of five main parts:
;; 1. defn
;; 2. function name
;; 3. a codstring describing the function (is optional)
;; 4. parameters listed in brackets
;; 5. function body
(defn                                     ; 1. defn
  function-example                        ; 2. function name
  "Just an example"                       ; 3. codstring description
  [param]                                 ; 4. parameters
  (str "str concatenates whit " param))   ; 5. function body
;; ADO to see the description of a function just do (doc funcition-name)

;; multi argument function
(defn multi-arg-func
  "Whit one arg, increment, whit two args, sum, whit three arg multiply them"
  ([one-param]
    (inc one-param))
  ([one two]
    (- one two))
  ([one two three]
    (* one two three)))

;; overloading can be also used to define any value of the function
(defn overload-text
  "Show user name and age"
  ([name age]
      (str "I " name " in my " age " year old working as a Analyst Developer"))
  ([name]
    (overload-text name "Jose")))

    (defn x-chop
      "Describe the kind of chop you're inflicting on someone"
      ([name chop-type]
         (str "I " chop-type " chop " name "! Take that!"))
      ([name]
         (x-chop name "karate")))

;; ======================== rest parameter ========================
;; things now is a list, this function can be invoked whit (favorite-things "study" "code" "workout" "play videogame")
(defn favorite-things
  "Show a string whit all my favorite things, thigs is a list of string"
  [& things]
  (str "Hi, my name is Jose, this is the things I like to do: "
    (clojure.string/join ", " things)))

;; rest parameter can be used inside a list to
(defn choices
  "Show the three choices and the rest separeted"
  [[fist-choice second-choice third-choice & unimportant-choices]]
  (println (str "Your first choice is: " fist-choice))
  (println (str "Your second choice is: " second-choice))
  (println (str "Your third choise is: " third-choice))
  (println (str "Your other choices are here: "
            (clojure.string/join ", " unimportant-choices))))

;; ======================== anonimous function ========================
;; is preceded by a hash mark
(#(str %1 " and " %2) "first param" "second param")

;; can be used with rest parameter too
(#(identity %&) 1 "blarg" :yip)

;; ======================== returning functions ========================
;; increment by a given value and recieve a parameter in its anonimous function as %
(defn increment-by-given-value
  "Increment the value by the function given value"
  [increment-by]
  #(+ % increment-by))

;; bind the function to 'increment'
(def increment (increment-by-given-value 5))

;; execute the function to increment 5 in 100
(increment 100)

;; ======================== loop and recursion ========================
;; loop over the content, validate whit if, and use recursion whit recur returning the value incremented by 1
(loop
  [iteration 0]
  (println (str "Iteration " iteration))
  (if (> iteration 3)
    (println "Goodbye!")
    (recur (inc iteration))))

;; ======================== praticing with hobbit's ========================
(def asym-hobbit-body-parts 
  [{:name "head" :size 3}
  {:name "left-eye" :size 1}
  {:name "left-ear" :size 1}
  {:name "mouth" :size 1}
  {:name "nose" :size 1}
  {:name "neck" :size 2}
  {:name "left-shoulder" :size 3}
  {:name "left-upper-arm" :size 3}
  {:name "chest" :size 10}
  {:name "back" :size 10}
  {:name "left-forearm" :size 3}
  {:name "abdomen" :size 6}
  {:name "left-kidney" :size 1}
  {:name "left-hand" :size 2}
  {:name "left-knee" :size 2}
  {:name "left-thigh" :size 4}
  {:name "left-lower-leg" :size 3}
  {:name "left-achilles" :size 1}
  {:name "left-foot" :size 2}])

(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})

;; using loop
(defn symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (loop [remaining-asym-parts asym-body-parts final-body-parts []]
    (if (empty? remaining-asym-parts)
      final-body-parts
      (let [[part & remaining] remaining-asym-parts]
        (recur remaining
          (into final-body-parts
            (set [part (matching-part part)])))))))

;; using reduce
(defn better-symmetrize-body-parts
  "Expects a sequence of maps that have a :name and :size"
  [ashym-body-parts]
  (reduce 
    (fn [final-body-parts part]
      (into final-body-parts (set [part (matching-part part)])))
    []
    ashym-body-parts))

(defn hit 
  "Hit function. 
  asym-body-parts: list of map containing :name and :size.
  sym_parts: list of map containing left and right side of the hobbit, each map item contains :name and :size.
  body-part-size-sum: The sum of each part.
  target: a random value contained in body-part-size-sum, used to reach the body part that will hit.
  part: first item from the sym-parts array.
  remaining: the rest of sym-parts array.
  accumulated-size: default: :size of the part, after the first loop receive from recur the size of itself + the first item of remaining."
  [asym-body-parts]
(println asym-body-parts)
  (let [sym-parts (better-symmetrize-body-parts asym-body-parts)
        body-part-size-sum (reduce + (map :size sym-parts))
        target (rand body-part-size-sum)]
    (loop [[part & remaining] sym-parts accumulated-size (:size part)]
      (if (> accumulated-size target)
        part
        (recur remaining (+ accumulated-size (:size (first remaining))))))))

;; ======================== exercices ========================
;; If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
;; Find the sum of all the multiples of 3 or 5 below 1000.
(loop [counter 0 accumulated 0]
  (if (>= counter 1000)
    accumulated
    (recur (inc counter) (+ accumulated (if (or (zero? (mod counter 3)) (zero? (mod counter 5))) counter 0)))))
;; answer: 2331658

;; Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:
;; 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
;; By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
(loop [sequence [1 1] accumulated 0]
  "Sum all the even number on the fibonacci sequence that are less than four million.
  sequence: fibonnaci sequence.
  accumulated: sum of all the even numbers on the sequence."
  (if (> (last sequence) 4000000)
    accumulated
    (let [[first-number & others] sequence]
      (recur 
        (conj sequence (+ (first (take-last 2 others)) (last others))) 
        (+ accumulated (if (zero? (mod (last others) 2)) (last others) 0))))))
;; answer 4613732

;; The prime factors of 13195 are 5, 7, 13 and 29.
;; What is the largest prime factor of the number 600851475143 ?
(loop [iterator 600851475143 divisor (/ (- iterator 1) 2) counter 0]
  (println (str "iterator: " iterator " divisor: " divisor " counter: " counter))
  (if (and (= 0 divisor) (= counter 1))
    iterator
    (if (< counter 2)
      (if (zero? (mod iterator divisor))
        (recur iterator (- divisor 1) (inc counter))
        (recur iterator (- divisor 1) counter))
      (recur (- iterator 1) (- iterator 2) 0))))