class Solution:
    def simplifyPath(self, path: str) -> str:
        parts = path.split('/')
        output_list = []
        for part in parts:
            if part == "..":
                if len(output_list) > 0:
                    output_list = output_list[:-1]
            elif part == ".":
                continue
            elif part == "":
                continue
            else:
                output_list.append(part)
        output = ""
        for part in output_list:
            output += "/" + part
        if len(output) > 0:
            return output
        else:
            return "/"

if __name__ == "__main__":
    solution = Solution()
    print(solution.simplifyPath("/Z/Iyy/HSyT/ItVqc/.././//Z/.././.././../a/gK/../ZurH///x/../////././../.."))
    print(solution.simplifyPath("/home/"))
    print(solution.simplifyPath("/../"))
    print(solution.simplifyPath("/home//foo/"))
    print(solution.simplifyPath("/a/./b/../../c/"))
    print(solution.simplifyPath("/a/../../b/../c//.//"))
    print(solution.simplifyPath("/a//b////c/d//././/.."))
