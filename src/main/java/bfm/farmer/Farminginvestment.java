package main.java.bfm.farmer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Int256;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.5.0.
 */
public class Farminginvestment extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b50604051608080610b65833981016040908152815160208301519183015160609093015160008054600160a060020a031990811633908117821617825560018054600160a060020a0390951694909116939093179092556004939093556005819055600691909155429091016007556003556008805460ff19169055610aca8061009b6000396000f30060806040526004361061008d5763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663319af33381146100925780633692d61a146100f85780633ca6268e1461015357806341c0e1b5146101ae5780638ccda08a146101c3578063b60e72cc146101ce578063c3b5563514610229578063e8b5e51f14610286575b600080fd5b34801561009e57600080fd5b506040805160206004803580820135601f81018490048402850184019095528484526100f694369492936024939284019190819084018382808284375094975050509235600160a060020a0316935061028e92505050565b005b34801561010457600080fd5b506040805160206004803580820135601f81018490048402850184019095528484526100f694369492936024939284019190819084018382808284375094975050933594506103459350505050565b34801561015f57600080fd5b506040805160206004803580820135601f81018490048402850184019095528484526100f694369492936024939284019190819084018382808284375094975050933594506103b29350505050565b3480156101ba57600080fd5b506100f6610417565b6100f660043561043a565b3480156101da57600080fd5b506040805160206004803580820135601f81018490048402850184019095528484526100f694369492936024939284019190819084018382808284375094975050933594506106529350505050565b34801561023557600080fd5b506040805160206004803580820135601f81018490048402850184019095528484526100f69436949293602493928401919081908401838280828437509497505050509135151592506106b7915050565b6100f6610720565b7f62ddffe5b5108385f7a590f100e1ee414ad9551a31f089e64e82998440785e1e8282604051808060200183600160a060020a0316600160a060020a03168152602001828103825284818151815260200191508051906020019080838360005b838110156103065781810151838201526020016102ee565b50505050905090810190601f1680156103335780820380516001836020036101000a031916815260200191505b50935050505060405180910390a15050565b7f02d93529bba9d141e5e06733c52c7e6fbcb1149586adb5c24064b522ab26f1d782826040518080602001836000191660001916815260200182810382528481815181526020019150805190602001908083836000838110156103065781810151838201526020016102ee565b7f6a837ff3973aa4181e7b9f07756f8b7ee366dd85a36655d2cb42cd47f10b96388282604051808060200183815260200182810382528481815181526020019150805190602001908083836000838110156103065781810151838201526020016102ee565b600054600160a060020a031633141561043857600054600160a060020a0316ff5b565b6000808260045402341415156104c0576040805160e560020a62461bcd02815260206004820152603b60248201527f4e6f742074686520726967687420616d6f756e74206f66206d6f6e657920746f60448201527f206275792074686174207175616e74697479206f66206d696c6b2e0000000000606482015290519081900360840190fd5b6008805460ff19166001179055600054600160a060020a03166108fc600234049081150290604051600060405180830381858888f1935050505015801561050b573d6000803e3d6000fd5b5060408051808201909152600881527f6661726d65723a20000000000000000000000000000000000000000000000000602082015261054d9060023404610652565b600091505b60035482101561064d5761271060023460065460028681548110151561057457fe5b9060005260206000209060020201600001546127100281151561059357fe5b040281151561059e57fe5b048115156105a857fe5b0490506002828154811015156105ba57fe5b60009182526020822060016002909202010154604051600160a060020a039091169183156108fc02918491818181858888f19350505050158015610602573d6000803e3d6000fd5b506106426040805190810160405280601681526020017f72657475726e206f6e20696e766573746d656e743a200000000000000000000081525082610652565b600190910190610552565b505050565b7f941296a39ea107bde685522318a4b6c2b544904a5dd82a512748ca2cf839bef78282604051808060200183815260200182810382528481815181526020019150805190602001908083836000838110156103065781810151838201526020016102ee565b7f4c34c2f9a78632f29fa59aaed5514cb742fd9fbcfd7ccc2c03c85f2bbc621c47828260405180806020018315151515815260200182810382528481815181526020019150805190602001908083836000838110156103065781810151838201526020016102ee565b6007546000904211156107a3576040805160e560020a62461bcd02815260206004820152602160248201527f496e76657374656d656e7420706572696f6420616c726561647920656e64656460448201527f2e00000000000000000000000000000000000000000000000000000000000000606482015290519081900360840190fd5b3490506107e56040805190810160405280601081526020017f696e766573746564416d6f756e743a200000000000000000000000000000000081525082610652565b60065460055482011115610843576040805160e560020a62461bcd02815260206004820152601760248201527f436f6e7472616374206f76657220696e7665737465642e000000000000000000604482015290519081900360640190fd5b60408051808201825282815233602080830191825260028054600181810183556000839052945191027f405787fa12a823e0f2b7631cc41b3ba8828b3321ca811111fa75cd3aa3bb5ace81019190915591517f405787fa12a823e0f2b7631cc41b3ba8828b3321ca811111fa75cd3aa3bb5acf9092018054600160a060020a039390931673ffffffffffffffffffffffffffffffffffffffff199093169290921790915560038054909201909155600580548401908190558251808401909352601283527f636f6c6c6563746564416d6d6f756e743a200000000000000000000000000000918301919091526109399190610652565b600654600554141561098e5761094d610991565b61098e6040805190810160405280600e81526020017f7265616368656420676f616c3a20000000000000000000000000000000000000815250600554610652565b50565b60065460055414610a12576040805160e560020a62461bcd02815260206004820152602f60248201527f476f616c20616d6f756e74206f66206d6f6e657920686173206e6f742079657460448201527f206265656e20636f6c6c65637465640000000000000000000000000000000000606482015290519081900360840190fd5b600154600654604051600160a060020a039092169181156108fc0291906000818181858888f19350505050158015610a4e573d6000803e3d6000fd5b506008805460ff19166001179081905560408051808201909152600d81527f636f777320626f756768743a200000000000000000000000000000000000000060208201526104389160ff166106b75600a165627a7a723058206858bc02bbd332494a12a3cd4c8c0d99cecf08338a376eb4d6de47f85bf73a6e0029";

    public static final String FUNC_LOG = "log";

    public static final String FUNC_KILL = "kill";

    public static final String FUNC_BUYMILK = "buyMilk";

    public static final String FUNC_INVEST = "invest";

    public static final Event LOGUINT_EVENT = new Event("LogUint", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event LOGINT_EVENT = new Event("LogInt", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Int256>() {}));
    ;

    public static final Event LOGBYTES32_EVENT = new Event("LogBytes32", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Bytes32>() {}));
    ;

    public static final Event LOGADDRESS_EVENT = new Event("LogAddress", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}));
    ;

    public static final Event LOGBOOL_EVENT = new Event("LogBool", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Bool>() {}));
    ;

    protected Farminginvestment(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Farminginvestment(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<TransactionReceipt> log(String s, String x) {
        final Function function = new Function(
                FUNC_LOG, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(s), 
                new org.web3j.abi.datatypes.Address(x)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> log(String s, byte[] x) {
        final Function function = new Function(
                FUNC_LOG, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(s), 
                new org.web3j.abi.datatypes.generated.Bytes32(x)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> log(String s, BigInteger x) {
        final Function function = new Function(
                FUNC_LOG, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(s), 
                new org.web3j.abi.datatypes.generated.Int256(x)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> kill() {
        final Function function = new Function(
                FUNC_KILL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> buyMilk(BigInteger quantity, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_BUYMILK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(quantity)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> log(String s, Boolean x) {
        final Function function = new Function(
                FUNC_LOG, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(s), 
                new org.web3j.abi.datatypes.Bool(x)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> invest(BigInteger weiValue) {
        final Function function = new Function(
                FUNC_INVEST, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public static RemoteCall<Farminginvestment> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _cowBreeder, BigInteger _goalAmount, BigInteger _milkPrice, BigInteger duration) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_cowBreeder), 
                new org.web3j.abi.datatypes.generated.Uint256(_goalAmount), 
                new org.web3j.abi.datatypes.generated.Uint256(_milkPrice), 
                new org.web3j.abi.datatypes.generated.Uint256(duration)));
        return deployRemoteCall(Farminginvestment.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<Farminginvestment> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _cowBreeder, BigInteger _goalAmount, BigInteger _milkPrice, BigInteger duration) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_cowBreeder), 
                new org.web3j.abi.datatypes.generated.Uint256(_goalAmount), 
                new org.web3j.abi.datatypes.generated.Uint256(_milkPrice), 
                new org.web3j.abi.datatypes.generated.Uint256(duration)));
        return deployRemoteCall(Farminginvestment.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public List<LogUintEventResponse> getLogUintEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(LOGUINT_EVENT, transactionReceipt);
        ArrayList<LogUintEventResponse> responses = new ArrayList<LogUintEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            LogUintEventResponse typedResponse = new LogUintEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.message = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.number = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<LogUintEventResponse> logUintEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, LogUintEventResponse>() {
            @Override
            public LogUintEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(LOGUINT_EVENT, log);
                LogUintEventResponse typedResponse = new LogUintEventResponse();
                typedResponse.log = log;
                typedResponse.message = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.number = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<LogUintEventResponse> logUintEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(LOGUINT_EVENT));
        return logUintEventObservable(filter);
    }

    public List<LogIntEventResponse> getLogIntEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(LOGINT_EVENT, transactionReceipt);
        ArrayList<LogIntEventResponse> responses = new ArrayList<LogIntEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            LogIntEventResponse typedResponse = new LogIntEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.message = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.number = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<LogIntEventResponse> logIntEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, LogIntEventResponse>() {
            @Override
            public LogIntEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(LOGINT_EVENT, log);
                LogIntEventResponse typedResponse = new LogIntEventResponse();
                typedResponse.log = log;
                typedResponse.message = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.number = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<LogIntEventResponse> logIntEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(LOGINT_EVENT));
        return logIntEventObservable(filter);
    }

    public List<LogBytes32EventResponse> getLogBytes32Events(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(LOGBYTES32_EVENT, transactionReceipt);
        ArrayList<LogBytes32EventResponse> responses = new ArrayList<LogBytes32EventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            LogBytes32EventResponse typedResponse = new LogBytes32EventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.message = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.number = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<LogBytes32EventResponse> logBytes32EventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, LogBytes32EventResponse>() {
            @Override
            public LogBytes32EventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(LOGBYTES32_EVENT, log);
                LogBytes32EventResponse typedResponse = new LogBytes32EventResponse();
                typedResponse.log = log;
                typedResponse.message = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.number = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<LogBytes32EventResponse> logBytes32EventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(LOGBYTES32_EVENT));
        return logBytes32EventObservable(filter);
    }

    public List<LogAddressEventResponse> getLogAddressEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(LOGADDRESS_EVENT, transactionReceipt);
        ArrayList<LogAddressEventResponse> responses = new ArrayList<LogAddressEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            LogAddressEventResponse typedResponse = new LogAddressEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.message = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.id = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<LogAddressEventResponse> logAddressEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, LogAddressEventResponse>() {
            @Override
            public LogAddressEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(LOGADDRESS_EVENT, log);
                LogAddressEventResponse typedResponse = new LogAddressEventResponse();
                typedResponse.log = log;
                typedResponse.message = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.id = (String) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<LogAddressEventResponse> logAddressEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(LOGADDRESS_EVENT));
        return logAddressEventObservable(filter);
    }

    public List<LogBoolEventResponse> getLogBoolEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(LOGBOOL_EVENT, transactionReceipt);
        ArrayList<LogBoolEventResponse> responses = new ArrayList<LogBoolEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            LogBoolEventResponse typedResponse = new LogBoolEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.message = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.state = (Boolean) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<LogBoolEventResponse> logBoolEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, LogBoolEventResponse>() {
            @Override
            public LogBoolEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(LOGBOOL_EVENT, log);
                LogBoolEventResponse typedResponse = new LogBoolEventResponse();
                typedResponse.log = log;
                typedResponse.message = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.state = (Boolean) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<LogBoolEventResponse> logBoolEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(LOGBOOL_EVENT));
        return logBoolEventObservable(filter);
    }

    public static Farminginvestment load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Farminginvestment(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Farminginvestment load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Farminginvestment(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class LogUintEventResponse {
        public Log log;

        public String message;

        public BigInteger number;
    }

    public static class LogIntEventResponse {
        public Log log;

        public String message;

        public BigInteger number;
    }

    public static class LogBytes32EventResponse {
        public Log log;

        public String message;

        public byte[] number;
    }

    public static class LogAddressEventResponse {
        public Log log;

        public String message;

        public String id;
    }

    public static class LogBoolEventResponse {
        public Log log;

        public String message;

        public Boolean state;
    }
}
