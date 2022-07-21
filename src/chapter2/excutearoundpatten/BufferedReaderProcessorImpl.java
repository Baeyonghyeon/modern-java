package chapter2.excutearoundpatten;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class BufferedReaderProcessorImpl implements BufferedReaderProcessor{

    @Override
    public String process(BufferedReader b) throws IOException {
        return null;
    }

    //함수형 인터페이스 자리에 람다를 사용할 수 있다.
    public String lambdaSampleFunction(BufferedReaderProcessor p) throws IOException{

        return null;
    }
}
