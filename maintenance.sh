echo "Executing final maintenance commit"
#run script for automated maintenance task
python maintenance.py

#push changes to git
git add .
git commit -m "COMP341-22A-Maintenance commit message"
git push origin main

