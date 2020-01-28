package bfm.farmer;

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
    private static final String BINARY = "608060405234801561001057600080fd5b5060405161052a38038061052a8339818101604052608081101561003357600080fd5b50805160208201516040830151606090930151600080546001600160a01b0319908116339081178216178255600180546001600160a01b0390961695909116949094179093556004939093556005829055600655429091016007556003556008805460ff19169055610480806100aa6000396000f3fe6080604052600436106100345760003560e01c806341c0e1b5146100395780638ccda08a14610050578063e8b5e51f1461006d575b600080fd5b34801561004557600080fd5b5061004e610075565b005b61004e6004803603602081101561006657600080fd5b5035610098565b61004e6101d5565b6000546001600160a01b0316331415610096576000546001600160a01b0316ff5b565b806004540234146100da5760405162461bcd60e51b815260040180806020018281038252603b8152602001806103c0603b913960400191505060405180910390fd5b6008805460ff191660011790556000546001600160a01b03166108fc600234049081150290604051600060405180830381858888f19350505050158015610125573d6000803e3d6000fd5b5060005b6003548110156101d1576002818154811061014057fe5b906000526020600020906002020160010160009054906101000a90046001600160a01b03166001600160a01b03166108fc346006546002858154811061018257fe5b9060005260206000209060020201600001548161019b57fe5b04029081150290604051600060405180830381858888f193505050501580156101c8573d6000803e3d6000fd5b50600101610129565b5050565b6007544211156102165760405162461bcd60e51b81526004018080602001828103825260218152602001806103fb6021913960400191505060405180910390fd5b60065460055434919082011115610274576040805162461bcd60e51b815260206004820152601760248201527f436f6e7472616374206f76657220696e7665737465642e000000000000000000604482015290519081900360640190fd5b60408051808201909152818152336020820190815260028054600181810183556000839052935191027f405787fa12a823e0f2b7631cc41b3ba8828b3321ca811111fa75cd3aa3bb5ace81019190915590517f405787fa12a823e0f2b7631cc41b3ba8828b3321ca811111fa75cd3aa3bb5acf90910180546001600160a01b03929092166001600160a01b031990921691909117905560038054909101905560058054820190819055600654141561032e5761032e610331565b50565b600654600554146103735760405162461bcd60e51b815260040180806020018281038252602f81526020018061041c602f913960400191505060405180910390fd5b6001546006546040516001600160a01b039092169181156108fc0291906000818181858888f193505050501580156103af573d6000803e3d6000fd5b506008805460ff1916600117905556fe4e6f742074686520726967687420616d6f756e74206f66206d6f6e657920746f206275792074686174207175616e74697479206f66206d696c6b2e496e76657374656d656e7420706572696f6420616c726561647920656e6465642e476f616c20616d6f756e74206f66206d6f6e657920686173206e6f7420796574206265656e20636f6c6c6563746564a2646970667358221220726aff94c41008964f9980b690afe85cc6aa9c63091fe783276869240f9f9d3a64736f6c63430006010033";

    public static final String FUNC_BUYMILK = "buyMilk";

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
