

buildMain(){
    echo "------------start build  main--------"
    buildWithDir .
    echo "------------end build main----------"
}

buildWithDir(){
    echo "------------start build $1--------"
    cd $1
    build
    cd -
    echo "------------end build $1--------"
}

build(){
    pwd
    ./gradlew -q projects
    ./gradlew -q clean
    ./gradlew -q assembleRelease
}

buildMain