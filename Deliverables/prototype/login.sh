clear 
echo "------------------------------------------------------"
echo "-- Welcome to the DCS Internship Management System! --"
echo "------------------------------------------------------"
echo
echo -n "Login: " # -n allows input at the end of this line
read username
echo -n "Password: "
stty -echo
read password
stty echo
echo
echo
if [ $username == "tws3r" ]; then
	echo "Logging in..."
	echo
	export USERTYPE="coordinator"
	sleep 2
	#bash ./adminHome.sh
elif [ $username == "1005730w" ]; then
	echo "Logging in..."
	echo	
	export USERTYPE="student"
	sleep 2
	#bash ./studentHome.sh
elif [ $username == "IBM" ]; then
	echo "Logging in..."
	echo
	export USERTYPE="company"
	sleep 2
	#bash ./companyHome.sh
else
	echo "Incorrect username or password, please try again."
	echo
	sleep 2
	bash ./login.sh
fi