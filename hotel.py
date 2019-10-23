import datetime
rooms_avail=[101,102,103,104,201,202,203,204]
maxx=4
rooms_booked=[]
gname=[]
check_in=[]
check_out=[]
cid=[]
nguest=[]
gname.append("null");
check_in.append("null");
check_out.append("null");
rooms_booked.append(0);
cid.append(0);
nguest.append(0);
while (1):
        print("\n1.Add a guest")
        print("2.Add a room")
        print("3.Add a booking")
        print("4.View bookings")
        print("5.EXIT")
        b=int(input("\nPlease select one option: "))
        if (b==1):

            name=input('Enter guest name: ')
            gname.append(name)
            cid.append(gname.index(name))
            print("guest id is :",gname.index(name))

        if (b==2):
            print("Rooms available are: ",rooms_avail)
            a=int(input("Room choice :"))
            if(a in rooms_avail):
                     print("max number of people can stay in this room is : 4")
                     rooms_booked.append(a)
                     rooms_avail.remove(a)
            else:
                    print("room number not valid.")
                    quit()
           
            
        if (b==3):
                idd=int(input("Enter guestId: "))
                if(idd in cid):
                  pass
                else:
                  print('Enter valid guestId.')
                  quit()
                room=int(input("Enter room number that guest registered : "))
                if(room in rooms_booked):
                  pass
                else:
                  print('Enter valid room number.')
                  quit()
                people=int(input("Number of people with registered guest : "))
                nguest.append(people)
                if(people<maxx):
                  pass;
                else:
                  print('Room capacity is less then the number of guest.Please register more rooms.')
                inDate = input("Enter the date in format 'dd/mm/yy' : ")
                day,month,year = inDate.split('/')
                outDate = input("Enter the date in format 'dd/mm/yy' : ")
                day1,month1,year1 = outDate.split('/')
                if(year!='2019'):
                        print("year is not valid.guest can resgister for the current year only.")
                        quit()
                else:
                        pass
                isval=True
                try:
                        datetime.datetime(int(year),int(month),int(day))
                        datetime.datetime(int(year1),int(month1),int(day1))
                except ValueError:
                        isval=False
                if(isval):
                        print("room is available on date",inDate)
                        check_in.append(inDate);
                        check_out.append(outDate);
                        
                else:
                        print("Input date is not valid.")
                        quit()
                  

        if (b==4):

            print("Please select one: \n" ,"1.View guest bookings \n","2.View room bookings")
            inp=int(input())
            if(inp==1):
                    ask=int(input("Please enter gurstId."))
                    print ("******Customer bookings******")
                    print ("Customer name:",gname[ask])
                    print ("Room no.",rooms_booked[ask])
                    if(nguest[ask]>4):
                            print("number of people is 4.")
                    else:
                            print("number of people",nguest[ask])
                    print ("Check in date:",check_in[ask])
                    print ("Check out date",check_out[ask])
            if(inp==2):
                    ask=int(input("Please enter room number: "))
                    a=rooms_booked.index(ask)
                    print ("******Room bookings******")
                    print ("Customer name:",gname[a])
                    if(nguest[ask]>4):
                            print("number of people is 4.")
                    else:
                            print("number of people",nguest[a])
                    print ("Check in date:",check_in[a])
                    print ("Check out date",check_out[a])

        if (b==5):
            quit()




