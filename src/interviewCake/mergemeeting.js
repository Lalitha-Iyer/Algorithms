

function mergeTime (meetList)
{

 //   console.log(JSON.stringify(meetList));
       
    if(meetList == undefined || meetList.length <1)
        return;
           
    meetList.sort(function(a,b){
            return (a["startTime"]-b["startTime"]); 
    });
    console.log('Before Merge'+JSON.stringify(meetList));
    
    prevStart = meetList[0]['startTime'];
    prevEnd = meetList[0]['endTime'];

    var result =[];
    result.push({'startTime':prevStart , 'endTime':prevEnd});
    
    for(i=0;i<meetList.length;i++){  

        currentMeeting = meetList[i]; 
        lastMergedMeeting = result[result.length-1];

        if(currentMeeting.startTime <= lastMergedMeeting.endTime){
            lastMergedMeeting.endTime =  Math.max(lastMergedMeeting.endTime, currentMeeting.endTime);
        }    
        else{   
            result.push(currentMeeting);
        }                          
   }
    return result;
}


console.log('After Merge'+JSON.stringify( mergeTime( [
    {startTime: 0,  endTime: 1},
    {startTime: 3,  endTime: 5},
    {startTime: 4,  endTime: 8},
    {startTime: 10, endTime: 12},
    {startTime: 9,  endTime: 10},
])));


console.log('After Merge'+JSON.stringify( mergeTime( [
    {startTime: 0,  endTime: 1}
])));


console.log('After Merge'+JSON.stringify( mergeTime( [
   
])));



console.log('After Merge'+JSON.stringify( mergeTime(  [{startTime: 1, endTime: 2}, {startTime: 2, endTime: 3}]
)));


// tricky case 
console.log('After Merge'+JSON.stringify( mergeTime(  [{startTime: 1, endTime: 5}, {startTime: 2, endTime: 3}]
)));


console.log('After Merge'+JSON.stringify( mergeTime(  [
    {startTime: 1, endTime: 10},
    {startTime: 2, endTime: 6},
    {startTime: 3, endTime: 5},
    {startTime: 7, endTime: 9},
]
)));


/*

  [
    {startTime: 0,  endTime: 1},
    {startTime: 3,  endTime: 5},
    {startTime: 4,  endTime: 8},
    {startTime: 10, endTime: 12},
    {startTime: 9,  endTime: 10},
]


*/
