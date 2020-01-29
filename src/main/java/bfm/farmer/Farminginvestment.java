package main.java.bfm.farmer;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

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
    private static final String BINARY = "608060405234801561001057600080fd5b506040516105433803806105438339818101604052608081101561003357600080fd5b50805160208201516040830151606090930151600080546001600160a01b0319908116339081178216178255600180546001600160a01b0390961695909116949094179093556004939093556005829055600655429091016007556003556008805460ff19169055610499806100aa6000396000f3fe60806040526004361061003f5760003560e01c806341c0e1b5146100445780638ccda08a1461005b57806398e1b41014610078578063e8b5e51f14610080575b600080fd5b34801561005057600080fd5b50610059610088565b005b6100596004803603602081101561007157600080fd5b50356100ab565b6100596101e8565b6100596101ee565b6000546001600160a01b03163314156100a9576000546001600160a01b0316ff5b565b806004540234146100ed5760405162461bcd60e51b815260040180806020018281038252603b8152602001806103d9603b913960400191505060405180910390fd5b6008805460ff191660011790556000546001600160a01b03166108fc600234049081150290604051600060405180830381858888f19350505050158015610138573d6000803e3d6000fd5b5060005b6003548110156101e4576002818154811061015357fe5b906000526020600020906002020160010160009054906101000a90046001600160a01b03166001600160a01b03166108fc346006546002858154811061019557fe5b906000526020600020906002020160000154816101ae57fe5b04029081150290604051600060405180830381858888f193505050501580156101db573d6000803e3d6000fd5b5060010161013c565b5050565b34600555565b60075442111561022f5760405162461bcd60e51b81526004018080602001828103825260218152602001806104146021913960400191505060405180910390fd5b6006546005543491908201111561028d576040805162461bcd60e51b815260206004820152601760248201527f436f6e7472616374206f76657220696e7665737465642e000000000000000000604482015290519081900360640190fd5b60408051808201909152818152336020820190815260028054600181810183556000839052935191027f405787fa12a823e0f2b7631cc41b3ba8828b3321ca811111fa75cd3aa3bb5ace81019190915590517f405787fa12a823e0f2b7631cc41b3ba8828b3321ca811111fa75cd3aa3bb5acf90910180546001600160a01b03929092166001600160a01b03199092169190911790556003805490910190556005805482019081905560065414156103475761034761034a565b50565b6006546005541461038c5760405162461bcd60e51b815260040180806020018281038252602f815260200180610435602f913960400191505060405180910390fd5b6001546006546040516001600160a01b039092169181156108fc0291906000818181858888f193505050501580156103c8573d6000803e3d6000fd5b506008805460ff1916600117905556fe4e6f742074686520726967687420616d6f756e74206f66206d6f6e657920746f206275792074686174207175616e74697479206f66206d696c6b2e496e76657374656d656e7420706572696f6420616c726561647920656e6465642e476f616c20616d6f756e74206f66206d6f6e657920686173206e6f7420796574206265656e20636f6c6c6563746564a264697066735822122050c51669d76d299638f6884ed3a1f0914a7cb72c1e18f9f1eef43136d1717d7c64736f6c63430006010033";

    public static final String FUNC_BUYMILK = "buyMilk";

    public static final String FUNC_GETMONEY = "getMoney";

    public static final String FUNC_INVEST = "invest";

    public static final String FUNC_KILL = "kill";

    protected Farminginvestment(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Farminginvestment(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
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

    public RemoteCall<TransactionReceipt> buyMilk(BigInteger quantity) {
        final Function function = new Function(
                FUNC_BUYMILK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(quantity)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> getMoney() {
        final Function function = new Function(
                FUNC_GETMONEY, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> invest() {
        final Function function = new Function(
                FUNC_INVEST, 
                Arrays.<Type>asList(), 
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

    public static Farminginvestment load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Farminginvestment(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Farminginvestment load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Farminginvestment(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
