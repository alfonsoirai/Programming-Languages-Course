(def usBiggestCompanies
  (hash-map 1 "Berkshire Hathaway"
            2 "JPMorgan Chase"
            3 "Wells Fargo"
            4 "Bank of America"
            5 "Apple"
            6 "AT&T"
            7 "Citigroup"
            8 "ExxonMobil"
            9 "General Electric"
            10 "Wal-Mart Stores"
            11 "Verizon Communications"
            12 "Microsoft"
            13 "Alphabet"
            14 "Comcast"
            15 "Johnson & Johnson")
  )

(defn checkPosition
  [m number]
  (if (true?(contains? m number))
      (println "Company: " (get m number))
      (println "Position not registered.")
      )
    )

(println (nth (list 'UNAM 'IPN 'ITAM 'Anahuac 'UdeG) 2))

(def v [1 2 3 4 5])

(println (conj v 10))

(def exSeq #{2 4 6 8})
(println (conj exSeq 10 12))

(checkPosition usBiggestCompanies 3)
(coolUniversities)