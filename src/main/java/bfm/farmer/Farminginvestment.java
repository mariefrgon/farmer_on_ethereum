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
import org.web3j.abi.datatypes.DynamicBytes;
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
    private static final String BINARY = "608060405234801561001057600080fd5b50604051608080610a8e833981016040908152815160208301519183015160609093015160008054600160a060020a031990811633908117821617825560018054600160a060020a0390951694909116939093179092556004939093556005819055600691909155429091016007556003556008805460ff191690556109f38061009b6000396000f3006080604052600436106100615763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166341c0e1b58114610066578063588287131461007d5780638ccda08a14610092578063e8b5e51f1461009d575b600080fd5b34801561007257600080fd5b5061007b6100a5565b005b34801561008957600080fd5b5061007b6100c8565b61007b6004356101c3565b61007b61042d565b600054600160a060020a03163314156100c657600054600160a060020a0316ff5b565b60006007544211156101c0575060005b6003548110156101c05760028054829081106100f057fe5b60009182526020909120600291820201600101548154600160a060020a03909116916108fc918490811061012057fe5b600091825260208220600290910201546040518115909302929091818181858888f19350505050158015610158573d6000803e3d6000fd5b506101b86040805190810160405280601981526020017f72657475726e656420696e766573746564416d6f756e743a20000000000000008152506002838154811015156101a157fe5b906000526020600020906002020160000154610697565b6001016100d8565b50565b600080826004540234141515610249576040805160e560020a62461bcd02815260206004820152603b60248201527f4e6f742074686520726967687420616d6f756e74206f66206d6f6e657920746f60448201527f206275792074686174207175616e74697479206f66206d696c6b2e0000000000606482015290519081900360840190fd5b60085460ff1615156001146102a8576040805160e560020a62461bcd02815260206004820152601d60248201527f436f77732068617665206e6f74206265656e20626f7567687420796574000000604482015290519081900360640190fd5b600054600160a060020a03166108fc600234049081150290604051600060405180830381858888f193505050501580156102e6573d6000803e3d6000fd5b5060408051808201909152600881527f6661726d65723a2000000000000000000000000000000000000000000000000060208201526103289060023404610697565b600091505b6003548210156104285761271060023460065460028681548110151561034f57fe5b9060005260206000209060020201600001546127100281151561036e57fe5b040281151561037957fe5b0481151561038357fe5b04905060028281548110151561039557fe5b60009182526020822060016002909202010154604051600160a060020a039091169183156108fc02918491818181858888f193505050501580156103dd573d6000803e3d6000fd5b5061041d6040805190810160405280601681526020017f72657475726e206f6e20696e766573746d656e743a200000000000000000000081525082610697565b60019091019061032d565b505050565b6007546000904211156104b0576040805160e560020a62461bcd02815260206004820152602160248201527f496e76657374656d656e7420706572696f6420616c726561647920656e64656460448201527f2e00000000000000000000000000000000000000000000000000000000000000606482015290519081900360840190fd5b3490506104f26040805190810160405280601081526020017f696e766573746564416d6f756e743a200000000000000000000000000000000081525082610697565b60065460055482011115610550576040805160e560020a62461bcd02815260206004820152601760248201527f436f6e7472616374206f76657220696e7665737465642e000000000000000000604482015290519081900360640190fd5b60408051808201825282815233602080830191825260028054600181810183556000839052945191027f405787fa12a823e0f2b7631cc41b3ba8828b3321ca811111fa75cd3aa3bb5ace81019190915591517f405787fa12a823e0f2b7631cc41b3ba8828b3321ca811111fa75cd3aa3bb5acf9092018054600160a060020a039390931673ffffffffffffffffffffffffffffffffffffffff199093169290921790915560038054909201909155600580548401908190558251808401909352601283527f636f6c6c6563746564416d6d6f756e743a200000000000000000000000000000918301919091526106469190610697565b60065460055414156101c05761065a61073c565b6101c06040805190810160405280600e81526020017f7265616368656420676f616c3a200000000000000000000000000000000000008152506005545b7f941296a39ea107bde685522318a4b6c2b544904a5dd82a512748ca2cf839bef782826040518080602001838152602001828103825284818151815260200191508051906020019080838360005b838110156106fd5781810151838201526020016106e5565b50505050905090810190601f16801561072a5780820380516001836020036101000a031916815260200191505b50935050505060405180910390a15050565b600654600554146107bd576040805160e560020a62461bcd02815260206004820152602f60248201527f476f616c20616d6f756e74206f66206d6f6e657920686173206e6f742079657460448201527f206265656e20636f6c6c65637465640000000000000000000000000000000000606482015290519081900360840190fd5b600154600654604051600160a060020a039092169181156108fc0291906000818181858888f19350505050151561083b576107f661088a565b6108366040805190810160405280601281526020017f627579696e6720636f7773206661696c65640000000000000000000000000000815250600161095e565b6100c6565b6008805460ff19166001179081905560408051808201909152600d81527f636f777320626f756768743a200000000000000000000000000000000000000060208201526100c69160ff1661095e565b60005b6003548110156101c05760028054829081106108a557fe5b60009182526020909120600291820201600101548154600160a060020a03909116916108fc91849081106108d557fe5b600091825260208220600290910201546040518115909302929091818181858888f1935050505015801561090d573d6000803e3d6000fd5b506109566040805190810160405280601981526020017f72657475726e656420696e766573746564416d6f756e743a20000000000000008152506002838154811015156101a157fe5b60010161088d565b7f4c34c2f9a78632f29fa59aaed5514cb742fd9fbcfd7ccc2c03c85f2bbc621c47828260405180806020018315151515815260200182810382528481815181526020019150805190602001908083836000838110156106fd5781810151838201526020016106e55600a165627a7a72305820bf5a1ff799e9eefd81b2e8d3723ed99588df5a2964f9cb34ffa81b488d7829fb0029";

    public static final String FUNC_KILL = "kill";

    public static final String FUNC_REFUNDLIMITDATE = "refundLimitDate";

    public static final String FUNC_BUYMILK = "buyMilk";

    public static final String FUNC_INVEST = "invest";

    public static final Event LOGUINT_EVENT = new Event("LogUint", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event LOGINT_EVENT = new Event("LogInt", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Int256>() {}));
    ;

    public static final Event LOGBYTES_EVENT = new Event("LogBytes", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<DynamicBytes>() {}));
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

    public RemoteCall<TransactionReceipt> kill() {
        final Function function = new Function(
                FUNC_KILL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> refundLimitDate() {
        final Function function = new Function(
                FUNC_REFUNDLIMITDATE, 
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

    public List<LogBytesEventResponse> getLogBytesEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(LOGBYTES_EVENT, transactionReceipt);
        ArrayList<LogBytesEventResponse> responses = new ArrayList<LogBytesEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            LogBytesEventResponse typedResponse = new LogBytesEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.message = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.number = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<LogBytesEventResponse> logBytesEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, LogBytesEventResponse>() {
            @Override
            public LogBytesEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(LOGBYTES_EVENT, log);
                LogBytesEventResponse typedResponse = new LogBytesEventResponse();
                typedResponse.log = log;
                typedResponse.message = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.number = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<LogBytesEventResponse> logBytesEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(LOGBYTES_EVENT));
        return logBytesEventObservable(filter);
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

    public static class LogBytesEventResponse {
        public Log log;

        public String message;

        public byte[] number;
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
