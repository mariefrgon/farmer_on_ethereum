package main.java.bfm.farmer;


import main.java.bfm.farmer.Launcher.USERS.*;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.DefaultBlockParameterNumber;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.utils.Convert;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Demo program to deposit a helloworld smart contract in the blockchain using geth via web3j access.
 * Geth must powered up and mining, first:
 geth --datadir="elephantchain" --rpcapi personal,db,eth,net,web3 --rpc --nodiscover --mine --minerthreads=4 console
 * [*] runs the silent miner for an uninvolved third account.
 * [*] operates on the elephant chain
 */
public class Deployer
{

    // Password of the source account
    private final BigInteger GOAL_AMOUNT = BigInteger.valueOf(50000);
    private final BigInteger MILK_PRICE = BigInteger.valueOf(5);
    private final BigInteger DURATION = BigInteger.valueOf(900);

    public class User{
        public String location_source_account;
        public String account;
        public String account_pwd;
        public User(){}
        public User(String _location_source_account, String _account, String _account_pwd ){
            location_source_account = _location_source_account;
            account = _account;
            account_pwd = _account_pwd;
        }
    }

    private final User FARMER = new User(
            "/Users/mariefrance/Library/Ethereum/farmerchain/keystore/UTC--2020-01-28T13-20-56.406226000Z--b1020b2231eacf6ec05fb262630d8b9875d35b08",
            "0xb1020b2231eacf6ec05fb262630d8b9875d35b08",
            "root"
    );

    private final User INVESTOR_1 = new User(
            "/Users/mariefrance/Library/Ethereum/farmerchain/keystore/UTC--2020-01-28T10-18-34.296735000Z--d61c41f105c06c4e9558599d5b4df1faf05deac7",
            "0xd61c41f105c06c4e9558599d5b4df1faf05deac7",
            "farmerpwd"
    );

    private final User INVESTOR_2 = new User(
            "/Users/mariefrance/Library/Ethereum/farmerchain/keystore/UTC--2020-01-28T10-19-02.147516000Z--2657df43346f9dfe71aa0e58dc0c58b16d9a1dd5",
            "0x2657df43346f9dfe71aa0e58dc0c58b16d9a1dd5",
            "farmerpwd"
    );

    private final User CLIENT = new User(
            "/Users/mariefrance/Library/Ethereum/farmerchain/keystore/UTC--2020-01-29T16-17-20.101712000Z--4d19ff7da6d7a19e85c55ac9125f54ba70af2c76",
            "0x4d19FF7da6d7A19e85C55aC9125f54bA70AF2c76",
            "farmerpwd"
    );

    private final User COWBREEDER = new User(
            "/Users/mariefrance/Library/Ethereum/farmerchain/keystore/UTC--2020-01-28T10-17-21.419239000Z--d88032ecce65381e798503d56ad15db456c26adf",
            "0xd88032ecCE65381e798503D56Ad15Db456C26Adf",
            "farmerpwd"
    );



    public Farminginvestment transferContract (BigInteger _duration, BigInteger _goalAmount, BigInteger _milkPrice) throws Exception {

        // Connect to local node
        Web3j web3 = Web3j.build(new HttpService());  // defaults to http://localhost:8545/

        // Load credentials for accessing wallet of source account
        Credentials credentials = WalletUtils.loadCredentials(FARMER.account_pwd, FARMER.location_source_account);

        // Deploy the contract in the blockchain
        return Farminginvestment.deploy(web3, credentials, DefaultGasProvider.GAS_PRICE, DefaultGasProvider.GAS_LIMIT,
                COWBREEDER.account,
                _goalAmount, _milkPrice, _duration).send();

        }

    public Farminginvestment getContract (String contractAddress, Launcher.USERS username) throws Exception {

        // Connect to local node
        Web3j web3 = Web3j.build(new HttpService());  // defaults to http://localhost:8545/

        // Load credentials for accessing wallet of source account
        Credentials credentials = getCredentials(username);

        // Deploy the contract in the blockchain
        return Farminginvestment.load(contractAddress, web3, credentials, DefaultGasProvider.GAS_PRICE, DefaultGasProvider.GAS_LIMIT);

    }

    public String getBalance(Launcher.USERS username) throws IOException {
        //Web3j web3 = Web3j.build(new HttpService());  // defaults to http://localhost:8545/
        User user = getUser(username);
        //BigInteger balance =  web3.ethGetBalance(user.account, DefaultBlockParameterName.LATEST).send().getBalance();

        BigInteger balance = getBalance(user.account);
        return Convert.fromWei(balance.toString(), Convert.Unit.ETHER).toString();
    }

    public BigInteger getBalance (String accountId) {
        try {
            Web3j web3 = Web3j.build(new HttpService());  // defaults to http://localhost:8545/

            DefaultBlockParameter defaultBlockParameter = new DefaultBlockParameterNumber(web3.ethBlockNumber().send().getBlockNumber());
            EthGetBalance ethGetBalance = web3.ethGetBalance (accountId, defaultBlockParameter).send();
            if (ethGetBalance != null) {
                return ethGetBalance.getBalance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private User getUser(Launcher.USERS username){
        User user;

        switch (username){
            case Farmer:
                user = FARMER;
                break;
            case Investor1:
                user = INVESTOR_1;
                break;
            case Investor2:
                user = INVESTOR_2;
                break;
            case Client:
                user = CLIENT;
                break;
            case Cowbreeder:
                user = COWBREEDER;
                break;
            default:
                user = new User();
        };
        return user;
    }

    private Credentials getCredentials(Launcher.USERS username) throws IOException, CipherException {
        User user = getUser(username);
        return WalletUtils.loadCredentials(user.account_pwd, user.location_source_account);
    }
}


