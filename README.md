Deployment

mkdir target

# In create-job directory

yarn compile && yarn build
./zip.sh

# In root directory
serverless deploy
