function solution(maps) {
    const dr = [0,0,-1,1];
    const dc = [-1,1,0,0];
    
    
    const q = [];
    q.push([0, 0, 1]);
    while(q.length){
        const [cr,cc,dist] = q.shift();
        
        if(cr==maps.length -1 && cc == maps[0].length-1){
            return dist;
        }
        
        for(let d=0;d<4;d++){
            nr= cr+dr[d];
            nc = cc+dc[d];
            
             if(nr >= 0 && nr < maps.length && nc >= 0 && nc < maps[0].length && maps[nr][nc] === 1) {
            q.push([nr, nc, dist + 1]);
            maps[nr][nc] = 0;
             }
        }
    }
    return -1;
}