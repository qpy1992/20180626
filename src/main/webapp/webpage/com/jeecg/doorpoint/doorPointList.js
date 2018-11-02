//列表字段颜色 demo,逻辑判断函数
function fmtype(val,row,index){
    //可添加更多CSS样式
    var s1 = 'background-color:#ff5151;color:#FFF;';
    var s2 = 'background-color:#53ff53;color:#FFF;';
    var s3 = 'background-color:#21B9BB;';
    if (val =='Y') {
        return s1
    }
    if (val =='N') {
        return s2
    }
    return s3
}