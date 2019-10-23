(defparameter *id* '(0))
(defparameter *gn* '(0))
(defparameter *roomn* '(0))
(defparameter *gname* '(0))
(defparameter *checkin* '(0))
(defparameter *checkout* '(0))
(setq *opt1* 1)
(defvar x 1)
(defvar y 1)

(loop
		(princ "1.Add a guest ")
		(terpri)
	    (princ "2.Add a room ")
	    (terpri)
	    (princ "3.Add a booking ")
	    (terpri)
	    (princ "4.View bookings ")
	    (terpri)
	    (princ "5.EXIT")
	    (terpri)

  ( princ "Your Option :" )
  (setq opt (read))

  (if (= opt 1)
  	(progn
   ( princ "Guest name :" )
   (setq name (read))
   (push name *gname*)
   (terpri)
   ( princ "Guest id is:" )

   (push y *id*)
   (format t "~a ~%" (car *id*))
   (incf y)
   (terpri)
   )
  	)


  	  (if (= opt 2)
  	(progn
   ( princ "Enter room number from(1-10) :" )
   (setq roon (read))
   (push roon *roomn*)
   ( princ "Room limit is: 4" )
   (terpri)
   ( princ "Guest number:" )
   (setq gno (read))
   (push gno *gn*)
   )
   )
   
  	 (if (= opt 3)
  	(progn
   ( princ "Enter guest id :" )
   (setq idd (read))
   (if (member idd *id* )
   	( princ "Enter next Data" )
   	( princ "id is not valid." ))
   (terpri)

   ( princ "Enter room number :" )
   (setq rn (read))
   (if (member rn *roomn* )
   	( princ "Enter next Data" )

   	( princ "Room number is not valid." ))
   (terpri)


   ( princ "Enter number of guest :" )
   (setq ng (read))
   (if (< ng 4 )
   	( princ "Enter next Data" )
   	( princ "Room limit is 4.Please book more rooms." ))
   (terpri)


   ( princ "Enter the check-in date." )
   (terpri)
   ( princ "Day: " )
   (setq day (read))
   (terpri)
    ( princ "Month: " )
   (setq month (read))
   (terpri)
    ( princ "year: " )
   (setq year (read))
   (terpri)
    
    (defun leap  (year)
 
  (or (and (eql 0 (mod year 4)) (not (eql 0 (mod year 100))))
          (eql 0 (mod year 400))))

   (defun valid (day month year)
	(if (or (< month 1) (> month 12) )
		(defvar a 0) 
		(defvar a 1))
	(if (or (< day 1) (> day 31) )
		(defvar b 0) 
		(defvar b 1) )

	(if(= month 2)
		(if(leap year)
			(<= day 29)
			(<= day 28)))

    (if(or(or (= month 4) (= month 6)) (or (= month 9)(= month 11)))
    	(<= day 30))

 (if(and(= a 1)(= b 1) )
 	(progn
 	( princ "room is available on date: " )
 	(princ(concatenate 'string (write-to-string day) "/" (write-to-string month) "/" (write-to-string year )) )

 	(push (concatenate 'string (write-to-string day) "/" (write-to-string month) "/" (write-to-string year )) *checkin*)
	) 
	( princ "Date is not valid. " )
	)
	)
(valid day month year)

   (terpri)
( princ "Enter the check-out date." )
   (terpri)
   ( princ "Day: " )
   (setq day (read))
   (terpri)
    ( princ "Month: " )
   (setq month (read))
   (terpri)
    ( princ "year: " )
   (setq year (read))
   (terpri)
    
    (defun leap  (year)
  
  (or (and (eql 0 (mod year 4)) (not (eql 0 (mod year 100))))
          (eql 0 (mod year 400))))

   (defun valid (day month year)
	(if (or (< month 1) (> month 12) )
		(defvar a 0) 
		(defvar a 1))
	(if (or (< day 1) (> day 31) )
		(defvar b 0) 
		(defvar b 1) )

	(if(= month 2)
		(if(leap year)
			(<= day 29)
			(<= day 28)))

    (if(or(or (= month 4) (= month 6)) (or (= month 9)(= month 11)))
    	(<= day 30))

 (if(and(= a 1)(= b 1) )
 	(progn
 	( princ "room will be Empty on date: " )
 	(terpri)
 	(princ(concatenate 'string (write-to-string day) "/" (write-to-string month) "/" (write-to-string year )) )

 	(push (concatenate 'string (write-to-string day) "/" (write-to-string month) "/" (write-to-string year )) *checkout*)
	) 
	( princ "Date is not valid. " )
	)
	)
(valid day month year)



   

   )
   )


  	(if (= opt 4)
  	(progn
   ( princ "please select one: " )
   (terpri)
   (princ"1.View guest bookings ")
   (terpri)
   ( princ "2.View room bookings" )
   (terpri)
    (setq ye (read))
  (if (= ye 1)
  	(progn 
  		( princ "Enter guest id: " )
       (setq yes (read))
        (format t "id          = ~a ~b ~%"(car *id*) (cdr *id*) )
       (format t "name         = ~a ~b ~%" (car *gname*)(cdr *gname*) )
        (format t "no. of guest= ~a ~b ~%" (cdr *gn*) (cdr *gn*))
       (format t "room number  = ~a ~b ~%" (cdr *roomn*) (cdr *roomn*))
        (format t "checkin     = ~a ~b ~%" (cdr *checkin*) (cdr *checkin*))
       (format t "checkout     = ~a ~b ~%" (cdr *checkout*)(cdr *checkout*) )
       )
  	)
  (terpri)
   (if (= ye 2)
  	(progn 
  		( princ "Enter room number: " )
       (setq yes (read))
       (format t "id          = ~a ~b ~%"(car *id*) (cdr *id*) )
       (format t "name         = ~a ~b ~%" (car *gname*)(cdr *gname*) )
        (format t "no. of guest= ~a ~b ~%" (cdr *gn*) (cdr *gn*))
       (format t "room number  = ~a ~b ~%" (cdr *roomn*) (cdr *roomn*))
        (format t "checkin     = ~a ~b ~%" (cdr *checkin*) (cdr *checkin*))
       (format t "checkout     = ~a ~b ~%" (cdr *checkout*)(cdr *checkout*) )
       )
  	)
   (terpri)
   (if (> ye 2)
   	( princ "Enter valid number. " ))
    )
  	)


  (if (= opt 5)
  	(quit)
  	)
(if (> opt 5)
  	( princ "Enter valid number. " )
  	)
(terpri)
(format t "Press 1 for Main Menu ~%")
	(format t "press 2 for exit the program ~%")
(setq x (read))
   (terpri)
(if (= x 1)
   ( princ "     Main Menu     " ))
(if (= x 2)
   	( princ "Thank you for visiting. " ))
	(when (= x 2) (return x))
	   (terpri)

)