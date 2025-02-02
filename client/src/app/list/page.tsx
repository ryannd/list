"use client"

import { AuthContext } from "@/features/auth/contexts/AuthProvider";
import { DataTable } from "@/features/list/components/List";
import useFetchList from "@/features/list/hooks/useFetchList";
import { Entry } from "@/features/list/types";
import { useContext } from "react";

export default function ListPage() {
    const { data, error } = useFetchList();
    const context = useContext(AuthContext)
    console.log(data)
    console.log(error)
    return <>
        {context?.idToken}
    </>
}