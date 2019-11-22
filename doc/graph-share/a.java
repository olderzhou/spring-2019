//k-expand

//for start in ['s_characters/633', 's_characters/627']
//        FOR v, e, p IN 0..2 OUTBOUND start
//        childOf
////RETURN { v, e, p }
//        filter p.vertices[1].name=='Jaime'
//        FILTER p.edges[*].gender ALL == 'male'
//        FILTER p.edges[*].gener NONE == 'male'
//        return p

// 最短路径
/*
for  v,e in any SHORTEST_PATH 's_characters/633' to 's_characters/637' childOf
        return {v,e}
*/

//最小深度
/*
let deep = (
        for  v,e in any SHORTEST_PATH 's_characters/633' to 's_characters/637' childOf
        return e
        )
        let d = count(deep) -1
return d
*/

//全路径
//let start = 1
//let end = count(deep)
/*
for v,e,p in 1..3 OUTBOUND 's_characters/633'
childOf
filter p.vertices[2]._id=='s_characters/637'
return p
*/