pragma solidity ^0.4.26;

contract mortal {
    address farmer;
    constructor() public { farmer = msg.sender; }
    function kill() public { if (msg.sender == farmer) selfdestruct(farmer); }
    
    //console.log
    event LogUint(string, uint);
    function log(string memory s , uint x) internal {
       emit LogUint(s, x);
    }
    
    event LogInt(string, int);
    function log(string memory s , int x) internal {
        emit LogInt(s, x);
    }

    
    event LogBytes(string, bytes);
    function log(string memory s , bytes x) internal {
        emit LogBytes(s, x);
    }
    
    event LogBytes32(string, bytes32);
    function log(string memory s , bytes32 x) internal {
        emit LogBytes32(s, x);
    }

    event LogAddress(string, address);
    function log(string memory s , address x) internal {
        emit LogAddress(s, x);
    }

    event LogBool(string, bool);
    function log(string memory s , bool x) internal {
        emit LogBool(s, x);
    }
}

contract farminginvestment is mortal {

    struct Investor{
        uint investedAmount;
        address id;
    }

    address cowBreeder;

    Investor[] investors;
    uint nbInvestors;

    uint milkPrice;

    uint collectedAmount;
    uint goalAmount;
    uint limitDate;
    bool cowsBought;

    constructor(address _cowBreeder, uint _goalAmount, uint _milkPrice, uint duration) public{
        farmer = msg.sender;

        cowBreeder = _cowBreeder;
        milkPrice = _milkPrice;
        collectedAmount = 0;
        goalAmount = _goalAmount;
        limitDate = now + duration;
        nbInvestors = 0;

        cowsBought = false;

    }

    function invest() public payable {
        // No arguments are necessary, all
        // information is already part of
        // the transaction. The keyword payable
        // is required for the function to
        // be able to receive Ether.

        // Revert the call if the investement period is over.
        require(
            now <= limitDate,
            "Investement period already ended."
        );
    
        uint _investedAmount = msg.value;
        log("investedAmount: ", _investedAmount);
    
        // Vérifications que la somme ne dépasse pas le goal
        require(
            collectedAmount + _investedAmount <= goalAmount,
            "Contract over invested."
        );
        // Si tout va bien jusque la, on accepte l'investisseur donc creation de l'investisseur
        investors.push(Investor({investedAmount:_investedAmount, id:msg.sender}));

        // On met à jour les params
        nbInvestors = nbInvestors + 1;
        collectedAmount = collectedAmount + _investedAmount;
        log("collectedAmmount: ", collectedAmount);

        // End ?
        if(collectedAmount == goalAmount){
            goalAmountReached();
            log("reached goal: ", collectedAmount);
        }
        
    }

    function goalAmountReached() internal {
        require(
            collectedAmount == goalAmount,
             "Goal amount of money has not yet been collected"
        );
        
        cowBreeder.transfer(goalAmount);
        cowsBought = true;
        log("cows bought: ", cowsBought);
    }

    function buyMilk (uint quantity) public payable {
        require (
            msg.value == milkPrice * quantity,
            "Not the right amount of money to buy that quantity of milk."
        );

        require (
            cowsBought = true,
            "Cows have not been bought yet"
        );

        //envoyer une partie au fermier
        farmer.transfer(msg.value / 2);
        log("farmer: ", msg.value/2);

        // et une partie aux investors
        for (uint i = 0; i < nbInvestors; i++){
            //potentiellement problème d'approximation du calcul de la share?
            uint part = (((investors[i].investedAmount*10000 / goalAmount)*msg.value/2)/10000);
            investors[i].id.transfer(part);
            log("return on investment: ", part);
        }
    }
    
    function refund() public{
        if(now > limitDate){
            for (uint i = 0; i < nbInvestors; i++){
                investors[i].id.transfer(investors[i].investedAmount);
                log("returned investedAmount: ", investors[i].investedAmount);
            }

        }
        
    }
    
}
