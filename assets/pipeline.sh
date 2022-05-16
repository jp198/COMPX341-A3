echo "(1) Installing npm"
npm install

echo "(2) Compiling the application"
if npm run build; then
	echo "Build successful"
	git add .
	git commit -m "COMPX341-22A-A3 Comitting from CI/CD Pipeline"
	git push origin main
else 
	echo "Build failed, exiting pipeline"
	exit
fi

echo "(3) Deploying the application locally"
npm run start
