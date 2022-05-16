echo "(1) Installing npm"
npm install

echo "(2) Compiling the application"
if npm run build; then
	echo "Build successful"
	git add .
	git commit -m "$1"
	#check if a custom commit message has been given
	if [ -z "$1" ]; then 
		echo "Commit Error: Please add a custom commit message"
		exit
	else
		git push origin main
		echo "Pushed changes to github"
fi
else 
	echo "Build failed, exiting pipeline"
	exit
fi

echo "(3) Deploying the application locally"
npm run start
