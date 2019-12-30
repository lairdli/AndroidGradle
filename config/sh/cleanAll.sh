

buildMain(){
    echo "------------start build main--------"
    buildWithDir .
    buildWithDir channel
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
    ./gradlew -q clean
}

buildMain